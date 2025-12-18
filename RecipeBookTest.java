import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * The test class Tests2.
 *
 * @author  Giuliano Di Fulvio
 * @version (a version number or a date)
 */
public class RecipeBookTest
{
    @Test
    public void testAddRecipe() {
        RecipeBook book = new RecipeBook();

        book.addRecipeTest("Pasta", "main dish");

        assertEquals(1, book.getRecipeCount());
    }

    @Test
    public void testRateRecipe() {
        RecipeBook book = new RecipeBook();
        book.addRecipeTest("Cake", "dessert");

        book.rateRecipeTest("Cake", 5);

        assertEquals(5, book.getRecipeRatingTest("Cake"));
    }

    @Test
    public void testRateInvalidRecipe() {
        RecipeBook book = new RecipeBook();

        assertEquals(false, book.rateRecipeTest("Fake", 4));
    }

    @Test
    public void testCountByType() {
        RecipeBook book = new RecipeBook();

        book.addRecipeTest("Burger", "main dish");
        book.addRecipeTest("Salad", "appetizer");
        book.addRecipeTest("Steak", "main dish");

        assertEquals(2, book.countByTypeTest("main dish"));
    }

    @Test
    public void testRecipeCount() {
        RecipeBook book = new RecipeBook();

        book.addRecipeTest("Ice Cream", "dessert");
        book.addRecipeTest("Soup", "appetizer");

        assertEquals(2, book.getSize());
    }
}