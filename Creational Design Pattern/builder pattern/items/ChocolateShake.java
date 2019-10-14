package items;

public class ChocolateShake extends Milkshake {
    public ChocolateShake() {
        super("chocolate shake", 230);
    }

    @Override
    public String getIngredient() {
        String ingredient = "ingredients: ";

        if(getIsLactoseFree() == true) {
            ingredient += "almond milk, ";
        } else {
            ingredient += "milk, ";
        }

        ingredient += "sugar, chocolate syrup, chocolate icecream";

        return ingredient;
    }
}
