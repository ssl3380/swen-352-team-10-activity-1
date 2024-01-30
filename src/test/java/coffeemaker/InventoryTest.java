package coffeemaker;

import coffeemaker.exceptions.InventoryException;
import coffeemaker.exceptions.RecipeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {

    private Inventory inventory;

    @BeforeEach
    void init() {
        inventory = new Inventory();
    }

    @Test
    void testConstructor() {
        assertEquals(15, inventory.getCoffee());
        assertEquals(15, inventory.getMilk());
        assertEquals(15, inventory.getSugar());
        assertEquals(15, inventory.getChocolate());
    }

    @Test
    void testAddSugarDefect() throws InventoryException {
        inventory.addSugar("10");
        assertEquals(25, inventory.getSugar());
    }

    @Test
    void testUseIngredientsDefect() throws RecipeException {
        Recipe testRecipe = new Recipe();
        testRecipe.setAmtCoffee("10");
        inventory.useIngredients(testRecipe);
        assertEquals(5, inventory.getCoffee());
    }

    @Test
    void testAddChocolate() throws InventoryException {
        assertThrows(InventoryException.class, () -> {
            inventory.addChocolate("not a number");
        });
        assertThrows(InventoryException.class, () -> {
            inventory.addChocolate("-10");
        });

        inventory.addChocolate("10");
        assertEquals(25, inventory.getChocolate());
    }

    @Test
    void testAddCoffee() throws InventoryException {
        assertThrows(InventoryException.class, () -> {
            inventory.addCoffee("not a number");
        });
        assertThrows(InventoryException.class, () -> {
            inventory.addCoffee("-10");
        });

        inventory.addCoffee("10");
        assertEquals(25, inventory.getCoffee());
    }

    @Test
    void testAddMilk() throws InventoryException {
        assertThrows(InventoryException.class, () -> {
            inventory.addMilk("not a number");
        });
        assertThrows(InventoryException.class, () -> {
            inventory.addMilk("-10");
        });

        inventory.addMilk("10");
        assertEquals(25, inventory.getMilk());
    }

    @Test
    void testAddSugar() throws InventoryException {
        assertThrows(InventoryException.class, () -> {
            inventory.addSugar("not a number");
        });
        assertThrows(InventoryException.class, () -> {
            inventory.addSugar("-10");
        });

        inventory.addSugar("10");
        assertEquals(25, inventory.getSugar());
    }

    @Test
    void testUseIngredients() throws RecipeException {
        Recipe testRecipe = new Recipe();
        testRecipe.setAmtCoffee("10");
        testRecipe.setAmtMilk("10");
        testRecipe.setAmtSugar("10");
        testRecipe.setAmtChocolate("10");

        boolean result = inventory.useIngredients(testRecipe);

        assertTrue(result);
        assertEquals(5, inventory.getCoffee());
        assertEquals(5, inventory.getMilk());
        assertEquals(5, inventory.getSugar());
        assertEquals(5, inventory.getChocolate());

        result = inventory.useIngredients(testRecipe);
        assertFalse(result);
    }

    @Test
    void testToString() {
        StringBuffer buf = new StringBuffer();
        buf.append("Coffee: ");
        buf.append("15");
        buf.append("\n");
        buf.append("Milk: ");
        buf.append("15");
        buf.append("\n");
        buf.append("Sugar: ");
        buf.append("15");
        buf.append("\n");
        buf.append("Chocolate: ");
        buf.append("15");
        buf.append("\n");
        String output = buf.toString();
        assertEquals(output, inventory.toString());
    }

}
