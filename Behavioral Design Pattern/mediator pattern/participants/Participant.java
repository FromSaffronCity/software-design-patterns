package participants;

import mediators.ExamControllerOffice;
import results.ExamPackage;

public abstract class Participant {
    private ExamControllerOffice examControllerOffice;  // mediator
    private int id;

    public Participant(ExamControllerOffice examControllerOffice, int id) {
        this.examControllerOffice = examControllerOffice;
        this.id = id;
    }

    public ExamControllerOffice getExamControllerOffice() {
        return examControllerOffice;
    }

    public int getID() {
        return id;
    }

    public abstract void receive(ExamPackage examPackage);
}
