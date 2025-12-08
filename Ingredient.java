
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
    
    public Ingredient(String name, double amount, Measurements measurement){
        this.name = name;
        this.amount = amount;
        this.measurement = measurement;
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
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setAmount(double amount){
        this.amount = amount;
    }
    
    public void setMeasurement(Measurements measurement){
        this.measurement = measurement;
    }  
}
