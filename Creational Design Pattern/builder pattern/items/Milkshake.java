package items;

public abstract class Milkshake extends Item {
    private boolean isLactoseFree;

    public Milkshake(String name, int basePrice) {
        super(name, basePrice);
    }

    public void setIsLactoseFree(boolean isLactoseFree) {
        this.isLactoseFree = isLactoseFree;
        return ;
    }

    public boolean getIsLactoseFree() {
        return isLactoseFree;
    }

    @Override
    public int getPrice() {
        if(isLactoseFree == true) {
            return getBasePrice()+60;
        } else {
            return getBasePrice();
        }
    }
}
