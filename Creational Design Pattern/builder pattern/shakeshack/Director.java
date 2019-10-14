package shakeshack;

import builders.MilkshakeBuilder;

public class Director {
    private MilkshakeBuilder milkshakeBuilder;

    public Director(MilkshakeBuilder milkshakeBuilder) {
        this.milkshakeBuilder = milkshakeBuilder;
    }

    public void makeOrder(boolean isLactoseFree, int candyCount, int cookieCount) {
        /* adding milkshake */
        milkshakeBuilder.addMilkShake(isLactoseFree);

        /* adding candy */
        for(int i=0; i<candyCount; i++) {
            milkshakeBuilder.addCandy();
        }

        /* adding cookie */
        for(int i=0; i<cookieCount; i++) {
            milkshakeBuilder.addCookie();
        }

        return ;
    }

    public Order getOrder() {
        return milkshakeBuilder.getOrder();
    }
}
