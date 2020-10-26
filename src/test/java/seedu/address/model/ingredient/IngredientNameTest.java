package seedu.address.model.ingredient;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class IngredientNameTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new IngredientName(null));
    }

    @Test
    public void constructor_invalidAmount_throwsIllegalArgumentException() {
        String invalidIngredientName = "";
        assertThrows(IllegalArgumentException.class, () -> new IngredientName(invalidIngredientName));
    }

    @Test
    public void isValidIngredientName() {
        // null name
        assertThrows(NullPointerException.class, () -> IngredientName.isValidIngredientName(null));

        // invalid name
        assertFalse(IngredientName.isValidIngredientName("")); // empty string
        assertFalse(IngredientName.isValidIngredientName(" ")); // spaces only
        assertFalse(IngredientName.isValidIngredientName("^")); // only non-alphanumeric characters
        assertFalse(IngredientName.isValidIngredientName("Milk*")); // contains non-alphanumeric characters
        assertFalse(IngredientName.isValidIngredientName("Black Sugar")); // does not appear in the predefined list

        // valid name
        assertTrue(IngredientName.isValidIngredientName("Milk"));
        assertTrue(IngredientName.isValidIngredientName("Boba"));
        assertTrue(IngredientName.isValidIngredientName("Pearl"));
        assertTrue(IngredientName.isValidIngredientName("Black Tea"));
        assertTrue(IngredientName.isValidIngredientName("Green Tea"));
        assertTrue(IngredientName.isValidIngredientName("Brown Sugar"));
    }
}
