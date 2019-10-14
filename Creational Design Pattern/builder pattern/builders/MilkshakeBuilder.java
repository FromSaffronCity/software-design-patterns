package builders;

import shakeshack.Order;
import items.Candy;
import items.Cookie;

public abstract class MilkshakeBuilder {
    private Order order;

    public MilkshakeBuilder() {
        order = new Order();
    }

    public abstract void addMilkShake(boolean isLactoseFree);

    public void addCandy() {
        order.addItem(new Candy());
        return ;
    }

    public void addCookie() {
        order.addItem(new Cookie());
        return ;
    }

    public Order getOrder() {
        return order;
    }
}
