package factories;

import components.*;

public class FactoryB implements ComputerFactory {
    /* concrete factory */
    public FactoryB() {
        /* nothing here */
    }

    @Override
    public Cpu getCpu() {
        return new CpuB();
    }

    @Override
    public Mmu getMmu() {
        return new MmuB();
    }

    @Override
    public Resolution getResolution() {
        return new ResolutionB();
    }
}
