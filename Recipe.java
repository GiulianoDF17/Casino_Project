import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a description of class Recipes here.
 *
 * @author Daniel Corcuera Lodico
 * @version (a version number or a date)
 */


public class Recipe 
{
    private String name;
    private Steps steps;
    private ArrayList<Ingredient> ingredients;
    private int rating;
    private String type;
    public static void main(String[] args){
        boolean run = true;
        Scanner myobj = new Scanner (System.in);
        RecipeBook recipebook = new RecipeBook();
        
         while (run) {
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("1. Add a recipe");
        System.out.println("2. List all recipes");
        System.out.println("3. Print recipe Details");
        System.out.println("4. List by type");
        System.out.println("5. Rate a recipe");
        System.out.println("6. Search by title or ingredient");
        System.out.println("7. List top rated recipe");
        System.out.println("8. Exit");
        System.out.println();
        System.out.print("Choice: ");
        
        int choice = myobj.nextInt();
        System.out.println();
        switch(choice){
            case 1:
                recipebook.addRecipe();
                break;
            case 2:
                recipebook.listAllRecipes();
                break;
            case 3:
                recipebook.searchRecipeName();
                
                break;
            case 4:    
                recipebook.listByType();
                break;
            case 5:    
                recipebook.rateRecipe();
                break;
            case 6:    
                recipebook.searchByIngredient();
                break;
            case 7:    
                recipebook.listTopRated();
                break;
            case 8:  
                System.out.println("Goodbye!");
                run = false;
                break;
            
            default:    
                System.out.println("That is not a correct number");
                System.out.println("Please choose a number from 1-8");
                System.out.println();
        }
      }
    }
    
    public Recipe(String name, String type) {
        this.name = name;
        this.ingredients = new ArrayList<>();
        this.type = type.toLowerCase();
        this.rating = 0;
    }
    
    public void setRating(int rating){
        this.rating = rating;
    }
    
    public ArrayList<Ingredient> getIngredients(){
        return ingredients;
    }
    
    public int getRating(){
        return rating;
    }
    
    public String getName() {
        return name;
    }

    public String getType(){
        return type;
    }
    
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    } 
}
