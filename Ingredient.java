import java.util.Scanner;
/**
 * Write a description of class Ingredient here.
 *
 * @author Giuliano Di Fulvio
 * @version (a version number or a date)
 */
public class Ingredient 
{
    private String name;
    private double amount;
    private Measurements measurement;
    Scanner myobj = new Scanner (System.in);
    
    public Ingredient(String name, double amount, Measurements measurement){
        this.name = name;
        this.amount = amount;
        this.measurement = measurement;
    }
    
    public String toString(){
        return amount + " " + measurement + " " + name;
    }
    
    public String getName(){
        return name;
    }
    
    public double getAmount(){
        return amount;
    }
    
    public Measurements getMeasurement(){
        return measurement;
    }
    
    //Daniel
    public String setName(){
        System.out.println("What are the ingredients?");
        
        String ingredientName = myobj.nextLine().trim().toLowerCase();
        return(ingredientName);
    }
    
    public String setMoreNames(){
        System.out.println("Anything else?");
        
        String ingredientName = myobj.nextLine().trim().toLowerCase();
        return(ingredientName);
    }
    
    public void setAmount(double amount){
        this.amount = amount;
    }
    
    public void setMeasurement(Measurements measurement){
        this.measurement = measurement;
    }  
}
