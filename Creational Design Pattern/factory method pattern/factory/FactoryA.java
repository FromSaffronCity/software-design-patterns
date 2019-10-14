package factory;

import computers.Computer;
import computers.ComputerA;

public class FactoryA implements ComputerFactory {
    /* Concrete Creator */
    public FactoryA() {
        /* nothing here */
    }

    @Override
    public Computer getComputer() {
        return new ComputerA();
    }
}
