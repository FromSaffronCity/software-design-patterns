package participants;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import mediators.ExamControllerOffice;
import results.*;

public class Examiner extends Participant {
    private ExamScript examScript;

    public Examiner(ExamControllerOffice examControllerOffice, int id) {
        super(examControllerOffice, id);
    }

    public void sendExamPackage(List<ExamScript> examScripts) {
        Random random = new Random();
        List<Integer> marksheets = new ArrayList<>();

        /* NOTICE */
        int index = random.nextInt(examScripts.size());

        for(int i=0; i<examScripts.size(); i++) {
            if(i == index) {
                marksheets.add(examScripts.get(i).getScriptMarks()+1);  // must mistake
                continue;
            }

            int randNum = random.nextInt(10);

            if(randNum%2 == 0) {
                marksheets.add(examScripts.get(i).getScriptMarks()-1);  // made mistake (50% probability for mistake)
            } else {
                marksheets.add(examScripts.get(i).getScriptMarks());  // no mistake (50% probability for each exam script)
            }
        }

        ExamPackage examPackage = new ExamPackage();
        examPackage.examScripts = examScripts;
        examPackage.marksheets = marksheets;

        System.out.println(">> exam scripts and marksheets sent from examiner with id "+getID());
        getExamControllerOffice().send(this, examPackage);

        return ;
    }

    public void reexamine() {
        if(examScript == null) {
            return ;  // operation failed(as no examScript is received yet)
        }

        ExamPackage examPackage = new ExamPackage();
        List<ExamScript> examScripts = new ArrayList<>();

        Random random = new Random();
        int randNum = random.nextInt(3)+2;

        if(randNum == 2) {
            /* do nothing */
        } else if(randNum == 3) {
            examScript.setScirptMarks(examScript.getScriptMarks()+4);

            if(examScript.getScriptMarks() > 100) {
                examScript.setScirptMarks(100);
            }

        } else if(randNum == 4) {
            examScript.setScirptMarks(examScript.getScriptMarks()-2);

            if(examScript.getScriptMarks() < 50) {
                examScript.setScirptMarks(50);
            }

        } else {
            /* unlikely case, do nothing */
        }

        examScript.setReexaminationStatus(randNum);

        examScripts.add(examScript);
        examPackage.examScripts = examScripts;

        System.out.println(">> reexamination response sent from examiner with id "+getID());
        getExamControllerOffice().send(this, examPackage);

        return ;
    }

    @Override
    public void receive(ExamPackage examPackage) {
        System.out.println(">> exam script received by examiner with id "+getID());
        examScript = examPackage.examScripts.get(0);  // NOTICE

        reexamine();  // NOTICE
        return ;
    }
}
