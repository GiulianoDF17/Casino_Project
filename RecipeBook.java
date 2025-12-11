import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Write a description of class Appetizer here.
 *
 * @author Giuliano Di Fulvio & Daniel Corcuera Lodico
 * @version (a version number or a date)
 */
public class RecipeBook
{
    private HashMap<String, Recipe> recipes;
    Scanner myobj = new Scanner (System.in);
    Ingredient ingredients = new Ingredient("default");
    MainDish mainDish = null;
    Dessert dessert = null;
    public RecipeBook() {
        recipes = new HashMap<>();
    }

    public void addRecipe() {
        System.out.println("What is the recipe name?");
        String recipeName = myobj.nextLine().trim().toLowerCase();
        Recipe recipe = new Recipe(recipeName);
        System.out.println("What type of dish is it?");
        String dishType = myobj.nextLine().trim().toLowerCase();
        if(dishType.equals("main dish") || dishType.equals("main")){
            System.out.println("Spice level(Scoville units): ");
            int spiceLevel = mainDish.getSpicyness();
            
        }
        if(dishType.equals("dessert") || dishType.equals("desert")){
            System.out.println("Grams of Sugar: ");
            int sugarGrams = dessert.getSugarGrams();
            
        }
        boolean addingIngredients = true;
        String ingredientInput = ingredients.setName();
        while(addingIngredients){
            String ingredientInput2 = ingredients.setMoreNames();
             if(ingredientInput.equals("done")){
                addingIngredients = false;
            } else {
                for (String ing : ingredientInput.split(",")) {
                  recipe.addIngredient(new Ingredient(ing.trim()));
                }
            }
        }

        recipes.put(recipeName.toLowerCase(), recipe);
        System.out.println("Recipe added!");
    }

     public void listAllRecipes() {
        if (recipes.isEmpty()) {
            System.out.println("No recipes in the book.");
            return;
        }
        System.out.println("Recipes:");
        int i = 0;
        for(String recipeName : recipes.keySet()){
            System.out.println(i + ". " + recipeName);
            i++;
        }
        System.out.println("Click ENTER when done");
        String enter = myobj.nextLine();
        System.out.println();
    }
    
    public void showBookDetails() {
        if (recipes.isEmpty()) {
            System.out.println("The recipe book is empty.");
            return;
        }
    }
    
    public void rateRecipe(){
        String recipeName = myobj.nextLine().trim().toLowerCase();
        Recipe recipe = recipes.get(recipeName);
        
        if(recipe == null){
            System.out.println("Recipe not found");
            return;
        }
        
        System.out.println("Enter a rating from 1-5");
        int ratingValue;
        
        while(true){
            ratingValue = Integer.parseInt(myobj.nextLine().trim());
                
            if(ratingValue >= 1 && ratingValue <= 5){
                recipe.setRating(ratingValue);
                break;
            }else{
                System.out.println("Please enter a number between 1-5");
            }
        }
    }
    
    public void listTopRated(){
        Iterator<Recipe> it =recipes.values().iterator();
        Recipe topRecipe = it.next();
        int highestRating = topRecipe.getRating();
        while (it.hasNext()) {
            Recipe current = it.next();
            if (current.getRating() > highestRating){
                highestRating = current.getRating();
                topRecipe = current;
            }
        }
        System.out.println();
        System.out.println("The top rated recipe is: " + topRecipe.getName() + highestRating);
    }
    
    public int getSize(){
        return recipes.size();
    }
    
    public int getRecipeCount() {
        return recipes.size();
    }
  
    public void searchRecipeName() {
        System.out.println("What is the recipe name?");
        String recipeSearch = myobj.nextLine().trim().toLowerCase();
        boolean found = false;
        Iterator<String> it = recipes.keySet().iterator();
        boolean tryAgain = true;
        int spiceLevel = mainDish.getSpicyness();
        while (tryAgain){
        while (it.hasNext()) {
            String name = it.next();
            if (name.toLowerCase().contains(recipeSearch.toLowerCase())) {
                System.out.println("Found: " + name);
                System.out.println("Ingredients: " + recipes.get(name));
                System.out.println("Spice level = " + spiceLevel + " scoville units");
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
        listByType("Desserts", Dessert.class);
    }

    public void listAppetizers() {
        listByType("Appetizers", Appetizer.class);
    }

    public void listMainDishes() {
        listByType("MainDishes", MainDish.class);
    }
}
