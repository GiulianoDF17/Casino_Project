
/**
 * Write a description of class Desserts here.
 *
 * @author Giuliano Di Fulvio
 * @version (a version number or a date)
 */
public class Desserts extends Recipes
{
    private int sugarGrams;
    
    public Desserts(String name, int sugarGrams){
        super(name);
        this.sugarGrams = sugarGrams;
    }
    
    public int getSugarGrams(){
        return sugarGrams;
    }
    
    public void listSugar(){
        System.out.println(getName() + " contains " + sugarGrams + "g of sugar.");
    }
}
