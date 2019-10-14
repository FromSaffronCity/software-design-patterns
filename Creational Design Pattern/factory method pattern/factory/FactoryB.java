package factory;

import computers.Computer;
import computers.ComputerB;

public class FactoryB implements ComputerFactory {
    /* Concrete Creator */
    public FactoryB() {
        /* nothing here */
    }

    @Override
    public Computer getComputer() {
        return new ComputerB();
    }
}
