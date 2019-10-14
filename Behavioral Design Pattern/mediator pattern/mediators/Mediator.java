package mediators;

import participants.Participant;
import results.ExamPackage;

public interface Mediator {
    void send(Participant participant, ExamPackage examPackage);
}
