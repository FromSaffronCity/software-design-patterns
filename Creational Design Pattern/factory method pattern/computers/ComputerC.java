package computers;

import components.CpuC;
import components.MmuC;
import components.ResolutionC;

public class ComputerC extends Computer {
    public ComputerC() {
        super("ComputerC", new CpuC(), new MmuC(), new ResolutionC());
    }
}
