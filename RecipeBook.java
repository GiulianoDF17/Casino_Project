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

    public void addRecipe() {
        System.out.println("What is the recipe name?");
        String recipeName = myobj.nextLine().trim().toLowerCase();

        System.out.println("What type is it? (maindish, appetizer, dessert)");
        String type = myobj.nextLine().trim().toLowerCase();

        Recipe recipe = new Recipe(recipeName, type);

        System.out.println("Enter ingredients (type 'done' to finish):");

        while (true) {
            System.out.print("Ingredient name: ");
            String name = myobj.nextLine().trim().toLowerCase();

            if (name.equals("done")) {
                break;
            }

            System.out.print("Amount: ");
            double amount = myobj.nextDouble();
            myobj.nextLine(); 

            System.out.println("Measurement options:");
            for (Measurements m : Measurements.values()) {
                System.out.println("- " + m);
            }

            System.out.print("Measurement: ");
            String measureInput = myobj.nextLine().trim().toUpperCase();

            Measurements measurement = Measurements.valueOf(measureInput);

            recipe.addIngredient(new Ingredient(name, amount, measurement));
        }

        recipes.put(recipeName, recipe);
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
        System.out.println("The top rated recipe is: " + topRecipe.getName() +" : " + highestRating);
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

    public void searchByIngredient(){
        System.out.println("enter ingredient name to search: ");
        String search = myobj.nextLine().trim().toLowerCase();
        
        boolean foundAny = false;
        
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
    
    public void listByType(){
        System.out.println("Which type do you want to list? MainDish, Appetizer, or Dessert?");
        String typeChoice = myobj.nextLine().trim().toLowerCase();
        
        boolean found = false;
        
        for(Recipe recipe : recipes.values()){
            if(recipe.getType().equals(typeChoice)){
                System.out.println(recipe.getName());
                found = true;
            }
        }
    }
    
    public int getRecipeRating(){
        return rating;
    }
}
