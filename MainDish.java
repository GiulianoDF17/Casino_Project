import java.util.Scanner;

/**
 * Write a description of class MainDish here.
 *
 * @author Giuliano Di Fulvio
 * @version (a version number or a date)
 */
public class MainDish extends Recipe
{
    private String spicyness;
    Scanner myobj = new Scanner (System.in);
    public MainDish(String name, String spicyness){
        super(name);
        this.spicyness = spicyness;
    }
    
    public int getSpicyness(){
        int spicyness = myobj.nextInt();
        return spicyness;
    }
    
    public void listSpicyness(){
        System.out.println(getName() + " has " + spicyness + " scoville units.");
    }
}
