package factories;

import components.Cpu;
import components.Mmu;
import components.Resolution;

public interface ComputerFactory {
    /* abstract factory */
    Cpu getCpu();
    Mmu getMmu();
    Resolution getResolution();
}
