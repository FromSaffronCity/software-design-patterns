package computers;

import components.CpuA;
import components.MmuA;
import components.ResolutionA;

public class ComputerA extends Computer {
    public ComputerA() {
        super("ComputerA", new CpuA(), new MmuA(), new ResolutionA());
    }
}
