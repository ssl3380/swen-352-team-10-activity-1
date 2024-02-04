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
    void testAddChocolateNotNumber() {
        assertThrows(InventoryException.class, () -> {
            inventory.addChocolate("not a number");
        });
        assertThrows(InventoryException.class, () -> {
            inventory.addChocolate(null);
        });
    }

    @Test
    void testAddChocolateNotPositiveInteger() {
        assertThrows(InventoryException.class, () -> {
            inventory.addChocolate("-10");
        });
        assertThrows(InventoryException.class, () -> {
            inventory.addChocolate("0");
        });
    }

    @Test
    void testAddChocolate() throws InventoryException {
        inventory.addChocolate("10");
        assertEquals(25, inventory.getChocolate());
    }

    @Test
    void testAddCoffeeNotNumber() {
        assertThrows(InventoryException.class, () -> {
            inventory.addCoffee("not a number");
        });
        assertThrows(InventoryException.class, () -> {
            inventory.addCoffee(null);
        });
    }

    @Test
    void testAddCoffeeNotPositiveInteger() {
        assertThrows(InventoryException.class, () -> {
            inventory.addCoffee("-10");
        });
        assertThrows(InventoryException.class, () -> {
            inventory.addCoffee("0");
        });
    }

    @Test
    void testAddCoffee() throws InventoryException {
        inventory.addCoffee("10");
        assertEquals(25, inventory.getCoffee());
    }

    @Test
    void testAddMilkNotNumber() {
        assertThrows(InventoryException.class, () -> {
            inventory.addMilk("not a number");
        });
        assertThrows(InventoryException.class, () -> {
            inventory.addMilk(null);
        });
    }

    @Test
    void testAddMilkNotPositiveInteger() {
        assertThrows(InventoryException.class, () -> {
            inventory.addMilk("-10");
        });
        assertThrows(InventoryException.class, () -> {
            inventory.addMilk("0");
        });
    }

    @Test
    void testAddMilk() throws InventoryException {
        inventory.addMilk("10");
        assertEquals(25, inventory.getMilk());
    }

    @Test
    void testAddSugarNotNumber() {
        assertThrows(InventoryException.class, () -> {
            inventory.addSugar("not a number");
        });
        assertThrows(InventoryException.class, () -> {
            inventory.addSugar(null);
        });
    }

    @Test
    void testAddSugarNotPositiveInteger() {
        assertThrows(InventoryException.class, () -> {
            inventory.addSugar("-10");
        });
        assertThrows(InventoryException.class, () -> {
            inventory.addSugar("-0");
        });
    }

    @Test
    void testAddSugar() throws InventoryException {
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
    }

    @Test
    void testUseIngredientsFail() throws RecipeException {
        Recipe testRecipe = new Recipe();
        testRecipe.setAmtCoffee("100");
        testRecipe.setAmtMilk("100");
        testRecipe.setAmtSugar("100");
        testRecipe.setAmtChocolate("100");

        boolean result = inventory.useIngredients(testRecipe);

        assertFalse(result);
        assertEquals(15, inventory.getCoffee());
        assertEquals(15, inventory.getMilk());
        assertEquals(15, inventory.getSugar());
        assertEquals(15, inventory.getChocolate());
    }

    @Test
    void testToString() {
        String output = "Coffee: " +
                "15" +
                "\n" +
                "Milk: " +
                "15" +
                "\n" +
                "Sugar: " +
                "15" +
                "\n" +
                "Chocolate: " +
                "15" +
                "\n";
        assertEquals(output, inventory.toString());
    }

    @Test
    void testSetChocolateNegative() {
        inventory.setChocolate(-10);
        assertEquals(15, inventory.getChocolate());
    }

    @Test
    void testSetCoffeeNegative() {
        inventory.setCoffee(-10);
        assertEquals(15, inventory.getCoffee());
    }

    @Test
    void testSetMilkNegative() {
        inventory.setMilk(-10);
        assertEquals(15, inventory.getMilk());
    }

    @Test
    void testSetSugarNegative() {
        inventory.setSugar(-10);
        assertEquals(15, inventory.getSugar());
    }
}
