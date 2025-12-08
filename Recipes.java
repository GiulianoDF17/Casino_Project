import java.util.ArrayList;
/**
 * Write a description of class Recipes here.
 *
 * @author Daniel Corcuera Lodico
 * @version (a version number or a date)
 */


public class Recipes 
{
    private String name;
    private ArrayList<Ingredient> ingredients;

    public Recipes(String name) {
        this.name = name;
        this.ingredients = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }
    
    public void removeIngredients(String ingredientName){
        ingredients.remove();
    }
    
    public void editIngredient(String ingredientName, String newName, double newAmount, Measurements newMeasurement) {
        for (Ingredient i : ingredients) {
            if (i.getName().equalsIgnoreCase(ingredientName)) {
                i.setName(newName);
                i.setAmount(newAmount);
                i.setMeasurement(newMeasurement);
                return;
            }
        }
    }
}
