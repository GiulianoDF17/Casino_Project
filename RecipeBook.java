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
    private int rating;
    Scanner myobj = new Scanner (System.in);
    
    public RecipeBook() {
        recipes = new HashMap<>();
    }
    
    //Daniel
    public void addRecipe() {
        System.out.println("What is the recipe name?");
        String recipeName = myobj.nextLine().trim().toLowerCase();

        System.out.println("What type is it? (main dish, appetizer, dessert)");
        String type = myobj.nextLine().trim().toLowerCase();
        Recipe recipe = new Recipe(recipeName, type);
        System.out.println("Enter ingredients (type 'done' to finish):");

        while (true) {
            System.out.print("Ingredient name: ");
            String name = myobj.nextLine().trim().toLowerCase();
            if (name.equals("done")) {
                break;
            }
            System.out.println("Measurement options:");
            for (Measurements m : Measurements.values()) {
                System.out.println("- " + m);
            }

            System.out.print("Measurement: ");
            String measureInput = myobj.nextLine().trim().toUpperCase();
            Measurements measurement = Measurements.valueOf(measureInput);
            System.out.print("Amount: ");
            double amount = myobj.nextDouble();
            myobj.nextLine(); 
            recipe.addIngredient(new Ingredient(name, amount, measurement));
        }

        recipes.put(recipeName, recipe);
        System.out.println("Recipe added!");
    }
    
    //Giuliano (Unit-Testing)
    public void addRecipeTest(String recipeName, String type) {
        recipeName = recipeName.trim().toLowerCase();
        type = type.trim().toLowerCase();

        Recipe recipe = new Recipe(recipeName, type);
        recipes.put(recipeName, recipe);
    }

    //Daniel
    public void listAllRecipes() {
        if (recipes.isEmpty()) {
            System.out.println("No recipes in the book.");
            return;
        }
        System.out.println("Recipes:");
        int i = 1;
        System.out.println();
        for(String recipeName : recipes.keySet()){
            System.out.println(i + ". " + recipeName);
            System.out.println();
            i++;
        }
        System.out.println("Click ENTER when done");
        String enter = myobj.nextLine();
        System.out.println();
    }
    
    //Giuliano
    public void showBookDetails() {
        System.out.println("Recipe Book Details");
        System.out.println("Author: Giuliano Di Fulvio & Daniel Corcuera Lodico");
        System.out.println("Date Created: December 10th, 2025");
        System.out.println("Total Recipes: " + recipes.size());
    }
    
    //Daniel
    public void rateRecipe(){
        System.out.println("Which recipe would you like to rate?");
        String recipeName = myobj.nextLine().trim().toLowerCase();
        Recipe recipe = recipes.get(recipeName);
        
        if(recipe == null){
            System.out.println("Recipe not found");
            return;
        }
        
        System.out.println("Enter a rating from 1-5");
        int ratingValue;
        
        while(true){
            ratingValue = myobj.nextInt();
                
            if(ratingValue >= 1 && ratingValue <= 5){
                recipe.setRating(ratingValue);
                break;
            }else{
                System.out.println("Please enter a number between 1-5");
            }
        }
        System.out.println("Done!");
    }
    
    //Giuliano (Unit-Testing)
    public boolean rateRecipeTest(String recipeName, int ratingValue) {
        recipeName = recipeName.trim().toLowerCase();
        Recipe recipe = recipes.get(recipeName);

        if (recipe == null) {
            return false;
        }

        if (ratingValue >= 1 && ratingValue <= 5) {
            recipe.setRating(ratingValue);
            return true;
        }

        return false;
    }
    
    //Daniel
    public void listTopRated(){
        Iterator<Recipe> it = recipes.values().iterator();
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
        System.out.println("The top rated recipe is: " + topRecipe.getName() +" : " + highestRating + "/5");
    }
    
    //Giuliano
    public int getSize(){
        return recipes.size();
    }
    
    //Giuliano
    public int getRecipeCount() {
        return recipes.size();
    }
      
    //Giuliano
    public void printRecipeDetails() {
      System.out.println("What is the recipe name?");
      String recipeSearch = myobj.nextLine().trim().toLowerCase();
      boolean found = false;
        
        for (Recipe recip : recipes.values()) {
           if (recip.getName().contains(recipeSearch)) {
              System.out.println("Found: " + recip.getName());
              System.out.println("Ingredients: " + recip.getIngredients());
              found = true;
            }
        }
        if (!found) {
            System.out.println("No recipes match your search.");
            System.out.println("Please try again");
        }
      
    }
    
    //Giuliano
    public void searchByIngredient(){
        System.out.println("Enter ingredient name to search: ");
        String search = myobj.nextLine().trim().toLowerCase();
        
        boolean foundAny = false;
        System.out.println("All recipes with " + search + ":");
        System.out.println();
        for(Recipe recipe : recipes.values()){
            for(Ingredient ing : recipe.getIngredients()){
                if (ing.getName().equals(search)){
                    System.out.println("- " + recipe.getName());
                    foundAny = true;
                    break;
                }
            }
        }
    }
    
    //Giuliano (Unit-Testing)
    public int searchByIngredientTest(String ingredientName) {
        ingredientName = ingredientName.toLowerCase();
        int count = 0;

        for (Recipe recipe : recipes.values()) {
            for (Ingredient ing : recipe.getIngredients()) {
                if (ing.getName().equals(ingredientName)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    //Giuliano
    public void listByType(){
        System.out.println("Which type do you want to list? Main Dish, Appetizer, or Dessert?");
        String typeChoice = myobj.nextLine().trim().toLowerCase();
        
        boolean found = false;
        
        for(Recipe recipe : recipes.values()){
            if(recipe.getType().equals(typeChoice)){
                System.out.println(recipe.getName());
                found = true;
            }
        }
    }
    
    //Giuliano (Unit-Testing)
    public int countByTypeTest(String type) {
        type = type.toLowerCase();
        int count = 0;

        for (Recipe recipe : recipes.values()) {
            if (recipe.getType().equals(type)) {
                count++;
            }
        }
        return count;
    }

    //Giuliano
    public int getRecipeRating(){
        return rating;
    }
    
    //Giuliano (Unit-Testing)
    public int getRecipeRatingTest(String recipeName) {
        Recipe recipe = recipes.get(recipeName.toLowerCase());
        if (recipe == null) {
            return -1;
        }
        return recipe.getRating();
    }
}
