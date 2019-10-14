package builders;

import items.Milkshake;
import items.CoffeeShake;

public class CoffeeShakeBuilder extends MilkshakeBuilder {
    public CoffeeShakeBuilder() {
        super();
    }

    @Override
    public void addMilkShake(boolean isLactoseFree) {
        Milkshake temp = new CoffeeShake();  // NOTICE
        temp.setIsLactoseFree(isLactoseFree);

        getOrder().addItem(temp);
        return ;
    }
}
