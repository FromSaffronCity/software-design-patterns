package subjects;

import observers.Observer;

public interface Subject {
    void attach(Observer observer);
    boolean detach(String name);
    void notifyAllObservers();
}
