package factory;

import computers.Computer;
import computers.ComputerC;

public class FactoryC implements ComputerFactory {
    /* Concrete Creator */
    public FactoryC() {
        /* nothing here */
    }

    @Override
    public Computer getComputer() {
        return new ComputerC();
    }
}
