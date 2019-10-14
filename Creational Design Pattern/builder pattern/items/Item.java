package items;

public abstract class Item {
    private String name;
    private int basePrice;

    public Item(String name, int basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public abstract int getPrice();
    public abstract String getIngredient();
}
