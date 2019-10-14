package factories;

import components.*;

public class FactoryC implements ComputerFactory {
    /* concrete factory */
    public FactoryC() {
        /* nothing here */
    }

    @Override
    public Cpu getCpu() {
        return new CpuC();
    }

    @Override
    public Mmu getMmu() {
        return new MmuC();
    }

    @Override
    public Resolution getResolution() {
        return new ResolutionC();
    }
}
