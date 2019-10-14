package builders;

import items.Milkshake;
import items.VanillaShake;

public class VanillaShakeBuilder extends MilkshakeBuilder {
    public VanillaShakeBuilder() {
        super();
    }

    @Override
    public void addMilkShake(boolean isLactoseFree) {
        Milkshake temp = new VanillaShake();  // NOTICE
        temp.setIsLactoseFree(isLactoseFree);

        getOrder().addItem(temp);
        return ;
    }
}
