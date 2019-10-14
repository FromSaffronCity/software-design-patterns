package factory;

import computers.*;

public class ComputerFactory {
    public ComputerFactory() {
        /* nothing here */
    }

    public Computer getComputer(String computerName) {
        if(computerName == null) {
            return null;
        } else if("ComputerA".equalsIgnoreCase(computerName)) {
            return new ComputerA();
        } else if("ComputerB".equalsIgnoreCase(computerName)) {
            return new ComputerB();
        } else if("ComputerC".equalsIgnoreCase(computerName)) {
            return new ComputerC();
        } else {
            return null;
        }
    }
}