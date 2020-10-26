package seedu.address.model.ingredient;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class IngredientTest {

    private static final Ingredient BLACK_TEA = new Ingredient(new IngredientName("Black Tea"));
    private static final Ingredient BLACK_TEA_VALID_AMOUNT = new Ingredient(new IngredientName(
            "Black Tea"), new Amount("90"));

    @Test
    public void isSameIngredient() {
        // same object -> returns true
        assertTrue(BLACK_TEA.isSameIngredient(BLACK_TEA));

        // null -> returns false
        assertFalse(BLACK_TEA.isSameIngredient(null));

        // different amount -> returns false
        assertFalse(BLACK_TEA.isSameIngredient(BLACK_TEA_VALID_AMOUNT));

        // different name -> returns false
        Ingredient editedBlackTea = new Ingredient(new IngredientName("Boba"));
        assertFalse(BLACK_TEA.isSameIngredient(editedBlackTea));

    }

    @Test
    public void testEquals() {
        // same values -> returns true
        Ingredient oolongCopy = new Ingredient(new IngredientName("Black Tea"));
        assertTrue(BLACK_TEA.equals(oolongCopy));

        // same object -> returns true
        assertTrue(BLACK_TEA.equals(BLACK_TEA));

        // null -> returns false
        assertFalse(BLACK_TEA.equals(null));

        // different type -> returns false
        assertFalse(BLACK_TEA.equals(5));

        // different ingredient name -> returns false
        assertFalse(BLACK_TEA.equals(new Ingredient(new IngredientName("Boba"))));

        // different amount -> returns false
        assertFalse(BLACK_TEA.equals(BLACK_TEA_VALID_AMOUNT));

    }
}
