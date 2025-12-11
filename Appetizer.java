
/**
 * Write a description of class Appetizer here.
 *
 * @author Giuliano Di Fulvio
 * @version (a version number or a date)
 */
public class Appetizer extends Recipe
{
    private String flavorType;
    
    public Appetizer(String name, String flavorType){
        super(name);
        this.flavorType = flavorType;
    }
    
    public String getFlavorType(){
        return flavorType;
    }
    
    public void listFlavor(){
        System.out.println(getName() + " has a " + flavorType + " flavor.");
    }
}
