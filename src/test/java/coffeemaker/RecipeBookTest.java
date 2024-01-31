package coffeemaker;

import coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeBookTest {

    private RecipeBook recipeBook;
    private Recipe testRecipe;
    private Recipe testRecipe2;
    private Recipe testRecipe3;
    private Recipe testRecipe4;
    private Recipe testEditRecipe;
    private Recipe [] testRecipeArray;

    @BeforeEach
    void init () {
        recipeBook = new RecipeBook();
        testRecipe = new Recipe();
        try {
            testRecipe.setName("addedRecipe");
            testRecipe.setPrice("1");
            testRecipe.setAmtCoffee("1");
            testRecipe.setAmtMilk("1");
            testRecipe.setAmtSugar("1");
            testRecipe.setAmtChocolate("1");
        } catch (RecipeException e) {
            System.out.println(e.getMessage());
        }
        testEditRecipe = new Recipe();
        try {
            testEditRecipe.setName("addedRecipe");
            testEditRecipe.setPrice("1");
            testEditRecipe.setAmtCoffee("1");
            testEditRecipe.setAmtMilk("1");
            testEditRecipe.setAmtSugar("1");
            testEditRecipe.setAmtChocolate("1");
        } catch (RecipeException e) {
            System.out.println(e.getMessage());
        }
        testRecipe2 = new Recipe();
        try {
            testRecipe2.setName("addedRecipe2");
            testRecipe2.setPrice("1");
            testRecipe2.setAmtCoffee("1");
            testRecipe2.setAmtMilk("1");
            testRecipe2.setAmtSugar("1");
            testRecipe2.setAmtChocolate("1");
        } catch (RecipeException e) {
            System.out.println(e.getMessage());
        }
        testRecipe3 = new Recipe();
        try {
            testRecipe3.setName("addedRecipe3");
            testRecipe3.setPrice("1");
            testRecipe3.setAmtCoffee("1");
            testRecipe3.setAmtMilk("1");
            testRecipe3.setAmtSugar("1");
            testRecipe3.setAmtChocolate("1");
        } catch (RecipeException e) {
            System.out.println(e.getMessage());
        }
        testRecipe4 = new Recipe();
        try {
            testRecipe4.setName("addedRecipe4");
            testRecipe4.setPrice("1");
            testRecipe4.setAmtCoffee("1");
            testRecipe4.setAmtMilk("1");
            testRecipe4.setAmtSugar("1");
            testRecipe4.setAmtChocolate("1");
        } catch (RecipeException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testAdd () {
        recipeBook.addRecipe(testRecipe);
        testRecipeArray = recipeBook.getRecipes();
        assertEquals(testRecipe.getName(), testRecipeArray[0].getName());
    }

    @Test
    void testDelete () {
        recipeBook.addRecipe(testRecipe);
        recipeBook.deleteRecipe(0);
        testRecipeArray = recipeBook.getRecipes();
        assertNull(testRecipeArray[0]);
    }

    @Test
    void testEdit () {
        recipeBook.addRecipe(testRecipe);
        recipeBook.editRecipe(0, testEditRecipe);
        testRecipeArray = recipeBook.getRecipes();
        assertEquals(testRecipe.getName(), testRecipeArray[0].getName());
    }

    @Test
    void testEditNullRecipe () {
        recipeBook.addRecipe(testRecipe);
        recipeBook.deleteRecipe(0);
        assertNull(recipeBook.editRecipe(1, testRecipe));
    }

    @Test
    void testDeleteNullRecipe () {
        assertNull(recipeBook.deleteRecipe(0));
    }

    @Test
    void testAddingTooManyRecipes () {
        recipeBook.addRecipe(testRecipe);
        recipeBook.addRecipe(testRecipe2);
        recipeBook.addRecipe(testRecipe3);
        recipeBook.addRecipe(testRecipe4);
        Recipe[] fourRecipes = recipeBook.getRecipes();
        recipeBook.addRecipe(testEditRecipe);
        assertEquals(fourRecipes, recipeBook.getRecipes());
    }

    @Test
    void testGetRecipes () {
        recipeBook.addRecipe(testRecipe);
        recipeBook.addRecipe(testRecipe2);
        recipeBook.addRecipe(testRecipe3);
        recipeBook.addRecipe(testRecipe4);
        testRecipeArray = recipeBook.getRecipes();
        assertEquals(testRecipeArray[0], testRecipe);
    }

    @Test
    void testAddingMaxRecipes () {
        recipeBook.addRecipe(testRecipe);
        recipeBook.addRecipe(testRecipe2);
        recipeBook.addRecipe(testRecipe3);
        recipeBook.addRecipe(testRecipe4);
        testRecipeArray = recipeBook.getRecipes();
        assertEquals(testRecipeArray[3], testRecipe4);
    }

    @Test
    void testEditingRecipeMultipleTimes () {
        recipeBook.addRecipe(testRecipe);
        recipeBook.editRecipe(0, testEditRecipe);
        recipeBook.editRecipe(0, testEditRecipe);
        testRecipeArray = recipeBook.getRecipes();
        assertEquals(testRecipe.getName(), testRecipeArray[0].getName());
    }

    @Test
    void testAddingSameRecipeTwice () {
        recipeBook.addRecipe(testRecipe);
        recipeBook.addRecipe(testRecipe);
        testRecipeArray = recipeBook.getRecipes();
        assertNull(testRecipeArray[1]);
    }

    @Test
    void testEditADeletedRecipe () {
        recipeBook.addRecipe(testRecipe);
        recipeBook.deleteRecipe(0);
        assertNull(recipeBook.editRecipe(0, testEditRecipe));
    }

    @Test
    void testAddSameRecipeAfterDeleting () {
        recipeBook.addRecipe(testRecipe);
        recipeBook.deleteRecipe(0);
        recipeBook.addRecipe(testRecipe);
        testRecipeArray = recipeBook.getRecipes();
        assertEquals(testRecipe, testRecipeArray[0]);
    }
}
