package builders;

import items.Milkshake;
import items.ZeroShake;

public class ZeroShakeBuilder extends MilkshakeBuilder {
    public ZeroShakeBuilder() {
        super();
    }

    @Override
    public void addMilkShake(boolean isLactoseFree) {
        Milkshake temp = new ZeroShake();  // NOTICE
        temp.setIsLactoseFree(isLactoseFree);

        getOrder().addItem(temp);
        return ;
    }
}
