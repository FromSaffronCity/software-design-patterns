package main;

import factories.*;

public class FactoryProducer {
    public static ComputerFactory getFactory(String computerName) {
        if(computerName == null) {
            return null;
        } else if("ComputerA".equalsIgnoreCase(computerName)) {
            return new FactoryA();
        } else if("ComputerB".equalsIgnoreCase(computerName)) {
            return new FactoryB();
        } else if("ComputerC".equalsIgnoreCase(computerName)) {
            return new FactoryC();
        } else {
            return null;
        }
    }
}
