package mediators;

import java.util.List;
import java.util.ArrayList;

import participants.*;
import results.*;

public class ExamControllerOffice implements Mediator {
    private List<Examiner> examiners;
    private List<Examinee> examinees;

    public ExamControllerOffice() {
        /* nothing here */
    }

    public void setExaminers(List<Examiner> examiners) {
        this.examiners = examiners;
        return ;
    }

    public void setExaminees(List<Examinee> examinees) {
        this.examinees = examinees;
        return ;
    }

    @Override
    public void send(Participant participant, ExamPackage examPackage) {
        if(participant instanceof Examinee) {
            System.out.println(">> reexamination request received from examinee with id "+participant.getID());

            System.out.println(">> reexamination request forwarded to examiner with id "+examPackage.examScripts.get(0).getExaminerID());  // NOTICE
            examiners.get(examPackage.examScripts.get(0).getExaminerID()-1).receive(examPackage);
        }

        if((participant instanceof Examiner) && (examPackage.marksheets==null)) {
            /* reexamination response */
            System.out.println(">> reexamination response received from examiner with id "+participant.getID());

            if(examPackage.examScripts.get(0).getReexaminationStatus() == 2) {
                System.out.println(">> marks unchanged");

            } else if(examPackage.examScripts.get(0).getReexaminationStatus() == 3) {
                System.out.println(">> marks increased");

            } else if(examPackage.examScripts.get(0).getReexaminationStatus() == 4) {
                System.out.println(">> marks decreased");

            } else {
                /* do nothing, unlikely case */
            }

            System.out.println(">> reexamination response forwarded to examinee with id "+examPackage.examScripts.get(0).getExamineeID());
            examinees.get(examPackage.examScripts.get(0).getExamineeID()-1).receive(examPackage);
        }

        if((participant instanceof Examiner) && (examPackage.marksheets!=null)) {
            /* exam scripts & marksheets sent */
            System.out.println(">> exam scripts and marksheets received from examiner with id "+participant.getID()+"\n");

            for(int i=0; i<examPackage.examScripts.size(); i++) {
                System.out.println("examinee id-"+examPackage.examScripts.get(i).getExamineeID()+": "+examPackage.marksheets.get(i));
            }

            System.out.println("\n"+"case of mistakes:-");

            for(int i=0; i<examPackage.examScripts.size(); i++) {
                if(examPackage.marksheets.get(i) != examPackage.examScripts.get(i).getScriptMarks()) {
                    System.out.println("examinee id-"+examPackage.examScripts.get(i).getExamineeID()+": "+examPackage.marksheets.get(i)+"(previous marks), "+examPackage.examScripts.get(i).getScriptMarks()+"(corrected marks)");
                }
            }

            System.out.println("");
            ExamPackage temp;

            /* NOTICE */
            for(int i=0; i<examPackage.examScripts.size(); i++) {
                temp = new ExamPackage();
                temp.examScripts = new ArrayList<>();
                temp.examScripts.add(examPackage.examScripts.get(i));

                System.out.println(">> result forwarded to examinee with id "+examPackage.examScripts.get(i).getExamineeID());
                examinees.get(examPackage.examScripts.get(i).getExamineeID()-1).receive(temp);
            }
        }

        return ;
    }
}
