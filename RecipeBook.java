import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class RecipeBook
{

    private HashMap<String, Recipes> recipes;

    public RecipeBook() {
        recipes = new HashMap<>();
    }

    public void addRecipe(String name, String ingredientString, Recipes recipe)
    {
        ArrayList<String> ingredientList = new ArrayList<>();
        for (String ingredient : ingredientString.split(",")) {
            ingredientList.add(ingredient.trim());
        }

        recipe.setIngredients(ingredientList);
        recipes.put(name, recipe);
    }

    public void showBookDetails() {
        if (recipes.isEmpty()) {
            System.out.println("The recipe book is empty.");
            return;
        }
    }
    
    public void removeRecipe(String name) {
        if (recipes.remove(name) != null) {
            System.out.println("Removed recipe: " + name);
        } else {
            System.out.println("Recipe not found: " + name);
        }
    }
    
    public int getRecipeCount() {
        return recipes.size();
    }
  
    public void searchRecipeName(String search) {
        boolean found = false;
        Iterator<String> it = recipes.keySet().iterator();
        boolean tryAgain = true;
        while (tryAgain){
        while (it.hasNext()) {
            String name = it.next();
            if (name.toLowerCase().contains(search.toLowerCase())) {
                System.out.println("Found: " + name);
                found = true;
                tryAgain = false;
            }
        }
        if (!found) {
            System.out.println("No recipes match your search.");
            System.out.println("Please try again");
        }
      }
    }

    private void listByType(String title, Class<?> type) {
        boolean found = false;
    }

    public void listDesserts() {
        listByType("Desserts", Desserts.class);
    }

    public void listAppetizers() {
        listByType("Appetizers", Appetizer.class);
    }

    public void listMainDishes() {
        listByType("MainDishes", MainDish.class);
    }
}
