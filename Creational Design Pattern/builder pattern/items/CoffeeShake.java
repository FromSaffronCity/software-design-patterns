package items;

public class CoffeeShake extends Milkshake {
    public CoffeeShake() {
        super("coffee shake", 230);
    }

    @Override
    public String getIngredient() {
        String ingredient = "ingredients: ";

        if(getIsLactoseFree() == true) {
            ingredient += "almond milk, ";
        } else {
            ingredient += "milk, ";
        }

        ingredient += "sugar, coffee, jello";

        return ingredient;
    }
}
