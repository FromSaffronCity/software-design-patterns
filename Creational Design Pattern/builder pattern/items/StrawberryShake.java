package items;

public class StrawberryShake extends Milkshake {
    public StrawberryShake() {
        super("strawberry shake", 200);
    }

    @Override
    public String getIngredient() {
        String ingredient = "ingredients: ";

        if(getIsLactoseFree() == true) {
            ingredient += "almond milk, ";
        } else {
            ingredient += "milk, ";
        }

        ingredient += "sugar, strawberry syrup, strawberry icecream";

        return ingredient;
    }
}
