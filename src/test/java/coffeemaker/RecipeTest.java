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
        } catch (RecipeException ignored) {
        }

    }

    @Test
    void testSetAmtChocolateWhenAmtNonNumeric() {
        Exception exception = assertThrows(RecipeException.class, () -> testRecipe.setAmtChocolate("chars"));
        String expectedMessage = "Units of chocolate must be a positive integer";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSetAmtChocolateWhenAmtNonPositive() {
        Exception exception = assertThrows(RecipeException.class, () -> testRecipe.setAmtChocolate("0"));
        String expectedMessage = "Units of chocolate must be a positive integer";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSetAmtChocolateWhenAmtPositive() {
        try {
            testRecipe.setAmtChocolate("3");
        } catch (RecipeException ignored) {
            fail("The units of chocolate must be a positive integer/greater than 0");
        }
        assertEquals(3, testRecipe.getAmtChocolate());
    }

    @Test
    void testSetAmtCoffeeWhenAmtNonNumeric() {
        Exception exception = assertThrows(RecipeException.class, () -> testRecipe.setAmtCoffee("chars"));
        String expectedMessage = "Units of coffee must be a positive integer";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSetAmtCoffeeWhenAmtNonPositive() {
        Exception exception = assertThrows(RecipeException.class, () -> testRecipe.setAmtCoffee("0"));
        String expectedMessage = "Units of coffee must be a positive integer";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSetAmtCoffeeWhenAmtPositive() {
        try {
            testRecipe.setAmtCoffee("3");
        } catch (RecipeException ignored) {
            fail("The units of coffee must be a positive integer/greater than 0");
        }
        assertEquals(3, testRecipe.getAmtCoffee());
    }

    @Test
    void testSetAmtMilkWhenAmtNonNumeric() {
        Exception exception = assertThrows(RecipeException.class, () -> testRecipe.setAmtMilk("chars"));
        String expectedMessage = "Units of milk must be a positive integer";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSetAmtMilkWhenAmtNonPositive() {
        Exception exception = assertThrows(RecipeException.class, () -> testRecipe.setAmtMilk("0"));
        String expectedMessage = "Units of milk must be a positive integer";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSetAmtMilkWhenAmtPositive() {
        // Positive test case
        try {
            testRecipe.setAmtMilk("3");
        } catch (RecipeException ignored) {
            fail("The units of milk must be a positive integer/greater than 0");
        }
        assertEquals(3, testRecipe.getAmtMilk());
    }

    @Test
    void testSetAmtSugarWhenAmtNonNumeric() {
        Exception exception = assertThrows(RecipeException.class, () -> testRecipe.setAmtSugar("chars"));
        String expectedMessage = "Units of sugar must be a positive integer";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSetAmtSugarWhenAmtNonPositive() {
        Exception exception = assertThrows(RecipeException.class, () -> testRecipe.setAmtSugar("0"));
        String expectedMessage = "Units of sugar must be a positive integer";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSetAmtSugarWhenAmtPositive() {
        try {
            testRecipe.setAmtSugar("3");
        } catch (RecipeException ignored) {
            fail("The units of sugar must be a positive integer/greater than 0");
        }
        assertEquals(3, testRecipe.getAmtSugar());
    }

    @Test
    void testSetNameWhenNull() {
        testRecipe.setName(null);
        assertEquals("", testRecipe.getName());
    }

    @Test
    void testSetName() {
        testRecipe.setName("caramel decaf");
        assertEquals("caramel decaf", testRecipe.getName());
    }

    @Test
    void testSetPriceWhenAmtNonNumeric() {
        Exception exception = assertThrows(RecipeException.class, () -> testRecipe.setPrice("chars"));
        String expectedMessage = "Price must be a positive integer";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSetPriceWhenAmtNonPositive() {
        Exception exception = assertThrows(RecipeException.class, () -> testRecipe.setPrice("0"));
        String expectedMessage = "Price must be a positive integer";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSetPriceWhenAmtPositive() {
        try {
            testRecipe.setPrice("3");
        } catch (RecipeException ignored) {
            fail("Price must be a positive integer/greater than 0");
        }
        assertEquals(3, testRecipe.getPrice());
    }

    @Test
    void testToString() {
        assertEquals("", testRecipe.toString());
    }

    @Test
    void testEqualsWhenTestSubjectNameEmptyTestAgainstNameEmpty() {
        assertEquals(testRecipeAgainst, testRecipe);
    }

    @Test
    void testEqualsWhenTestSubjectNameEmptyTestAgainstNameNotEmpty() {
        testRecipeAgainst.setName("I have a diff name than you");
        assertNotEquals(testRecipeAgainst, testRecipe);
    }

    @Test
    void testEqualsWhenTestSubjectNameNotEqualToTestAgainstName() {
        testRecipeAgainst.setName("I have a diff name than you");
        testRecipe.setName("Capp");
        assertNotEquals(testRecipeAgainst, testRecipe);
    }

    @Test
    void testEqualsWhenTestSubjectNameEqualToTestAgainstName() {
        testRecipe.setName("Capp");
        testRecipeAgainst.setName(testRecipe.getName());
        assertEquals(testRecipeAgainst, testRecipe);
    }

    @Test
    void testEqualsWhenTestSubjectMemLocEqualTestAgainstMemLoc() {
        testRecipeAgainst = testRecipe;
        assertEquals(testRecipeAgainst, testRecipe);
    }

    @Test
    void testEqualsWhenTestSubjectNull() {
        testRecipe = null;
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