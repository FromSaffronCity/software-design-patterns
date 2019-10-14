package participants;

import java.util.List;
import java.util.ArrayList;

import mediators.ExamControllerOffice;
import results.*;

public class Examinee extends Participant {
    private ExamScript examScript;

    public Examinee(ExamControllerOffice examControllerOffice, int id) {
        super(examControllerOffice, id);
    }

    public void requestReexamination() {
        if(examScript == null) {
            return ;  // operation failed(as no examScript is received yet)
        }

        ExamPackage examPackage = new ExamPackage();
        List<ExamScript> examScripts = new ArrayList<>();

        examScripts.add(examScript);
        examPackage.examScripts = examScripts;

        System.out.println(">> reexamination request sent from examinee with id "+getID());
        getExamControllerOffice().send(this, examPackage);

        return ;
    }

    @Override
    public void receive(ExamPackage examPackage) {
        System.out.println(">> exam script received by examinee with id "+getID());

        examScript = examPackage.examScripts.get(0);
        System.out.println(">> "+examScript);  // NOTICE
        return ;
    }
}
