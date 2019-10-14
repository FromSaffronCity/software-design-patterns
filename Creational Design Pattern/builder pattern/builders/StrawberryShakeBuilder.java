package builders;

import items.Milkshake;
import items.StrawberryShake;

public class StrawberryShakeBuilder extends MilkshakeBuilder {
    public StrawberryShakeBuilder() {
        super();
    }

    @Override
    public void addMilkShake(boolean isLactoseFree) {
        Milkshake temp = new StrawberryShake();  // NOTICE
        temp.setIsLactoseFree(isLactoseFree);

        getOrder().addItem(temp);
        return ;
    }
}
