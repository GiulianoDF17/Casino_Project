import java.util.Scanner;
/**
 * Write a description of class Desserts here.
 *
 * @author Giuliano Di Fulvio
 * @version (a version number or a date)
 */
public class Dessert extends Recipe
{
    private int sugarGrams;
    Scanner myobj = new Scanner (System.in);
    
    public Dessert(String name, int sugarGrams){
        super(name, "Dessert");
        this.sugarGrams = sugarGrams;
    }
    
    public int getSugarGrams(){
        int sugarGrams = myobj.nextInt();
        return sugarGrams;
    }
    
    public void listSugar(){
        System.out.println(getName() + " contains " + sugarGrams + "g of sugar.");
    }
}
