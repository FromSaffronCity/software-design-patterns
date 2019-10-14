package builders;

import items.Milkshake;
import items.ChocolateShake;

public class ChocolateShakeBuilder extends MilkshakeBuilder {
    public ChocolateShakeBuilder() {
        super();
    }

    @Override
    public void addMilkShake(boolean isLactoseFree) {
        Milkshake temp = new ChocolateShake();  // NOTICE
        temp.setIsLactoseFree(isLactoseFree);

        getOrder().addItem(temp);
        return ;
    }
}
