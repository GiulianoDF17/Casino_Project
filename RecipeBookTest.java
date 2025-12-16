

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

/**
 * The test class Tests2.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RecipeBookTest
{
    /**
     * Default constructor for test class Tests2
     */
    public RecipeBookTest()
    {
    }

    @Test
    public void testRecipeBookIsEmpty(){
        RecipeBook book = new RecipeBook();
        assertEquals(0, book.getRecipeCount());
    }
    
    @Test
    public void testAddRecipe(){
        RecipeBook book = new RecipeBook();
        String input = "pasta\n" + "maindish\n" + "rigatoni\n" + "200\n" + "GRAMS\n" + "done";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        book.addRecipe();
        assertEquals(1, book.getRecipeCount());
    }
}