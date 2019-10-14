package items;

public abstract class Topping extends Item {
    public Topping(String name, int basePrice) {
        super(name, basePrice);
    }

    @Override
    public int getPrice() {
        return getBasePrice();
    }

    @Override
    public String getIngredient() {
        return "";  // no ingredient specified
    }
}
