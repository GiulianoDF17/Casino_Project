import java.util.ArrayList;

/**
 * Write a description of class Steps here.
 *
 * @author Daniel Corcuera Lodico
 * @version (a version number or a date)
 */
public class Steps
{
    protected ArrayList<String> steps = new ArrayList<>();

    public void addStep(String step){
        steps.add(step);
    }
    public void removeStep(int index){ 
        steps.remove(index);
    }
    public void editStep(int index, String newStep){ 
        steps.set(index, newStep); 
    }
    public ArrayList<String> getSteps(){ 
        return steps; 
    }
}
