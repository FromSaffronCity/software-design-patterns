package computers;

import components.CpuB;
import components.MmuB;
import components.ResolutionB;

public class ComputerB extends Computer {
    public ComputerB() {
        super("ComputerB", new CpuB(), new MmuB(), new ResolutionB());
    }
}
