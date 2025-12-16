import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecipeTest {

    private Recipe recipe;

    @BeforeEach
    public void setUp() {
        recipe = new Recipe("Pizza", "Main");
    }
    @Test
    public void testGetName() {
        assertEquals("Pizza", recipe.getName());
    }

    @Test
    public void testGetType() {
        assertEquals("main", recipe.getType());
    }

    @Test
    public void testInitialRating() {
        assertEquals(0, recipe.getRating());
    }

    @Test
    public void testSetRating() {
        recipe.setRating(5);
        assertEquals(5, recipe.getRating());
    }

    public void testIngredientsInitiallyEmpty() {
        assertTrue(recipe.getIngredients().isEmpty());
    }


    @Test
    public void testAddIngredient() {
        Ingredient ingredient = new Ingredient("cheese", 1.0, Measurements.GRAMS);
        recipe.addIngredient(ingredient);

        assertEquals(1, recipe.getIngredients().size());
        assertEquals("cheese", recipe.getIngredients().get(0).getName());
    }
}
