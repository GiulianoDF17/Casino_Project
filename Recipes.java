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
    private ArrayList<String> ingredients;

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
    
    public ArrayList<String> getIngredients() {
        return ingredients;
    }
    
    public void removeingredients(ArrayList<String> ingList){
        
    }
    public void addIngredients(ArrayList<String> ingList) {
        this.ingredients = ingList;
    }
}
