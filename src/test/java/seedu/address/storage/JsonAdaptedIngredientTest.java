/*package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIngredients.MILK;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;

public class JsonAdaptedIngredientTest {
    private static final String VALID_INGREDIENT_NAME = "Milk";
    private static final String VALID_AMOUNT = "10";
    private static final String NULL_INGREDIENTNAME_EXCEPTION_MESSAGE = "Ingredient's IngredientName field is missing!";
    private static final String NULL_AMOUNT_EXCEPTION_MESSAGE = "Ingredient's Amount field is missing!";

    @Test
    public void toModelType_validIngredientComposition_returnsIngredient() throws Exception {
        JsonAdaptedIngredient ingredient = new JsonAdaptedIngredient(MILK);
        assertEquals(MILK, ingredient.toModelType());
    }

    @Test
    public void toModelType_nullIngredientName_throwsIllegalValueException() throws Exception {
        JsonAdaptedIngredient ingredient = new JsonAdaptedIngredient(null, VALID_AMOUNT);
        String expectedMessage = NULL_INGREDIENTNAME_EXCEPTION_MESSAGE;
        assertThrows(IllegalValueException.class, expectedMessage, ingredient::toModelType);
    }

    @Test
    public void toModelType_nullAmount_throwsIllegalValueException() throws Exception {
        JsonAdaptedIngredient ingredient = new JsonAdaptedIngredient(VALID_INGREDIENT_NAME, null);
        String expectedMessage = NULL_AMOUNT_EXCEPTION_MESSAGE;
        assertThrows(IllegalValueException.class, expectedMessage, ingredient::toModelType);
    }
}*/
