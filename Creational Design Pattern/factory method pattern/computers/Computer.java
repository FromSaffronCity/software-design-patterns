package computers;

import components.Cpu;
import components.Mmu;
import components.Resolution;

public abstract class Computer {
    private String name;
    private Cpu cpu;
    private Mmu mmu;
    private Resolution resolution;

    public Computer(String name, Cpu cpu, Mmu mmu, Resolution resolution) {
        this.name = name;
        this.cpu = cpu;  // NOTICE: initializing cpu
        this.mmu = mmu;  // NOTICE: initializing mmu
        this.resolution = resolution;  // initializing resolution
    }

    public String getName() {
        return name;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public Mmu getMmu() {
        return mmu;
    }

    public Resolution getResolution() {
        return resolution;
    }
}
