package items;

public class ZeroShake extends Milkshake {
    public ZeroShake() {
        super("zero shake", 240);
    }

    @Override
    public String getIngredient() {
        String ingredient = "ingredients: ";

        if(getIsLactoseFree() == true) {
            ingredient += "almond milk, ";
        } else {
            ingredient += "milk, ";
        }

        ingredient += "sweetener, vanilla flavoring, sugar-free jello";

        return ingredient;
    }
}
