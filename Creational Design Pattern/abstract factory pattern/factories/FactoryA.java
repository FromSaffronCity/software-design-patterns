package factories;

import components.*;

public class FactoryA implements ComputerFactory {
    /* concrete factory */
    public FactoryA() {
        /* nothing here */
    }

    @Override
    public Cpu getCpu() {
        return new CpuA();
    }

    @Override
    public Mmu getMmu() {
        return new MmuA();
    }

    @Override
    public Resolution getResolution() {
        return new ResolutionA();
    }
}
