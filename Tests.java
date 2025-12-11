

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class Tests.
 *
 * @author  Giuliano Di Fulvio
 * @version (a version number or a date)
 */
public class Tests
{
    private RecipeBook book;
    private Recipe recipe;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp(){
        book = new RecipeBook();
        recipe = new Recipe("Pizza");
    }

    @Test
    public void testAddRecipe(){
        book.addRecipe("Pizza", "Flour 5 cups, Eggs 2", recipe);
        assertEquals(1, book.getSize());
    }
}
