package observers;

import subjects.ABCServer;

public abstract class Observer {
    private ABCServer abcServer;  // subject
    private int state;
    private String name;

    public Observer(ABCServer abcServer, String name) {
        this.abcServer = abcServer;
        this.abcServer.attach(this);  // IMPORTANT

        this.name = name;
        state = 1;  // operational at beginning
    }

    public void setSubject(ABCServer abcServer) {
        this.abcServer = abcServer;
        return ;
    }

    public ABCServer getSubject() {
        return abcServer;
    }

    public void setState(int state) {
        this.state = state;
        return ;
    }

    public int getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    public abstract void notifyObserver();
    public abstract void update();
}
