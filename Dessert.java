
/**
 * Write a description of class Desserts here.
 *
 * @author Giuliano Di Fulvio
 * @version (a version number or a date)
 */
public class Dessert extends Recipe
{
    private int sugarGrams;
    
    public Dessert(String name, int sugarGrams){
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
