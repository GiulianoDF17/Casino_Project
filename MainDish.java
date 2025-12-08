
/**
 * Write a description of class MainDish here.
 *
 * @author Giuliano Di Fulvio
 * @version (a version number or a date)
 */
public class MainDish extends Recipes
{
    private String spicyness;
    
    public MainDish(String name, String spicyness){
        super(name);
        this.spicyness = spicyness;
    }
    
    public String getSpicyness(){
        return spicyness;
    }
    
    public void listSpicyness(){
        System.out.println(getName() + " has " + spicyness + " scoville units.");
    }
}
