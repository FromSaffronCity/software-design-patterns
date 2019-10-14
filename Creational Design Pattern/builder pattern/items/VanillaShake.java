package items;

public class VanillaShake extends Milkshake {
    public VanillaShake() {
        super("vanilla shake", 190);
    }

    @Override
    public String getIngredient() {
        String ingredient = "ingredients: ";

        if(getIsLactoseFree() == true) {
            ingredient += "almond milk, ";
        } else {
            ingredient += "milk, ";
        }

        ingredient += "sugar, vanilla flavoring, jello";

        return ingredient;
    }
}
