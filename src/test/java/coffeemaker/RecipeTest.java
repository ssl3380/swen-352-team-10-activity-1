package coffeemaker;

import coffeemaker.exceptions.RecipeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {
    Recipe testRecipe, testRecipeAgainst;

    @BeforeEach
    void setUp() {
        testRecipe = new Recipe();
        testRecipe.setName(null);
        testRecipeAgainst = new Recipe();
        testRecipeAgainst.setName(null);
        try {
            testRecipe.setPrice("5");
            testRecipe.setAmtCoffee("2");
            testRecipe.setAmtMilk("2");
            testRecipe.setAmtSugar("4");
            testRecipe.setAmtChocolate("1");
            testRecipeAgainst.setPrice("5");
            testRecipeAgainst.setAmtCoffee("2");
            testRecipeAgainst.setAmtMilk("2");
            testRecipeAgainst.setAmtSugar("4");
            testRecipeAgainst.setAmtChocolate("1");
        }catch (RecipeException ignored){
        }

    }

    @Test
    void testSetAmtChocolate() {
        //Non numeric test case
        Exception exception = assertThrows(RecipeException.class, () -> testRecipe.setAmtChocolate("non numeric"));
        String expectedMessage = "Units of chocolate must be a positive integer";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

        //0 test case
        exception = assertThrows(RecipeException.class, () -> testRecipe.setAmtChocolate("0"));
        actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

        // Positive test case
        try {
            testRecipe.setAmtChocolate("3");
        } catch (RecipeException ignored) {
            fail("The units of chocolate must be a positive integer/greater than 0");
        }
        // Check amount of chocolate is set to most recent modification
        assertEquals(3, testRecipe.getAmtChocolate());
    }

    @Test
    void testSetAmtCoffee() {
        //Non numeric test case
        Exception exception = assertThrows(RecipeException.class, () -> testRecipe.setAmtCoffee("non numeric"));
        String expectedMessage = "Units of coffee must be a positive integer";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

        //0 test case
        exception = assertThrows(RecipeException.class, () -> testRecipe.setAmtCoffee("0"));
        actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

        // Positive test case
        try {
            testRecipe.setAmtCoffee("3");
        } catch (RecipeException ignored) {
            fail("The units of coffee must be a positive integer/greater than 0");
        }
        // Check amount of chocolate is set to most recent modification
        assertEquals(3, testRecipe.getAmtCoffee());
    }

    @Test
    void testSetAmtMilk() {
        //Non numeric test case
        Exception exception = assertThrows(RecipeException.class, () -> testRecipe.setAmtMilk("non numeric"));
        String expectedMessage = "Units of milk must be a positive integer";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

        //0 test case
        exception = assertThrows(RecipeException.class, () -> testRecipe.setAmtMilk("0"));
        actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

        // Positive test case
        try {
            testRecipe.setAmtMilk("3");
        } catch (RecipeException ignored) {
            fail("The units of milk must be a positive integer/greater than 0");
        }
        // Check amount of chocolate is set to most recent modification
        assertEquals(3, testRecipe.getAmtMilk());
    }

    @Test
    void testSetAmtSugar() {
        //Non numeric test case
        Exception exception = assertThrows(RecipeException.class, () -> testRecipe.setAmtSugar("non numeric"));
        String expectedMessage = "Units of sugar must be a positive integer";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

        //0 test case
        exception = assertThrows(RecipeException.class, () -> testRecipe.setAmtSugar("0"));
        actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

        // Positive test case
        try {
            testRecipe.setAmtSugar("3");
        } catch (RecipeException ignored) {
            fail("The units of sugar must be a positive integer/greater than 0");
        }
        // Check amount of chocolate is set to most recent modification
        assertEquals(3, testRecipe.getAmtSugar());
    }

    @Test
    void testSetName() {
        //Null test case | Fail
        testRecipe.setName(null);
        assertEquals("", testRecipe.getName());

        //String test case | Pass
        testRecipe.setName("caramel decaf");
        assertEquals("caramel decaf", testRecipe.getName());
    }

    @Test
    void testSetPrice() {
        //Non numeric test case
        Exception exception = assertThrows(RecipeException.class, () -> testRecipe.setPrice("non numeric"));
        String expectedMessage = "Price must be a positive integer";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

        //0 test case
        exception = assertThrows(RecipeException.class, () -> testRecipe.setPrice("0"));
        actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

        // Positive test case
        try {
            testRecipe.setPrice("3");
        } catch (RecipeException ignored) {
            fail("Price must be a positive integer/greater than 0");
        }
        // Check amount of chocolate is set to most recent modification
        assertEquals(3, testRecipe.getPrice());
    }

    @Test
    void testToString() {
        assertEquals("", testRecipe.toString());
    }

    @Test
    void testEquals() {
        //Shall return equals as testRecipe and testRecipeAgainst name both ""
        assertEquals(testRecipeAgainst, testRecipe);

        //Shall return not equals as testRecipe name is "" and testRecipeAgainst name is not
        testRecipeAgainst.setName("I have a diff name than you");
        assertNotEquals(testRecipeAgainst, testRecipe);

        testRecipe.setName("Capp");
        //Shall return not equals as testRecipeAgainst and testRecipe name are not same
        assertNotEquals(testRecipeAgainst, testRecipe);

        testRecipeAgainst.setName(testRecipe.getName());
        //Shall return equals as testRecipe and testObj name are same
        assertEquals(testRecipeAgainst, testRecipe);

        testRecipeAgainst = testRecipe;
        //Shall return equals as testRecipeAgainst pt to exact mem loc as test testRecipe
        assertEquals(testRecipeAgainst, testRecipe);

        testRecipe = null;
        //Shall return not equals as testRecipe is null so nothing to compare
        assertNotEquals(testRecipeAgainst, testRecipe);
    }

    @Test
    void testHashCode() {
        //Shall return equals because both testRecipe and testRecipeAgainst have empty string val for name
        assertEquals(testRecipeAgainst.hashCode(), testRecipe.hashCode());
        testRecipe.setName("Capp");
        testRecipeAgainst.setName("Mach");
        //Shall return not equals because testRecipe and testRecipeAgainst have diff names
        assertNotEquals(testRecipeAgainst.hashCode(), testRecipe.hashCode());
        testRecipeAgainst.setName("Capp");
        //Shall return equals because both testRecipe and testRecipeAgainst have same name
        assertEquals(testRecipeAgainst.hashCode(), testRecipe.hashCode());
    }
}