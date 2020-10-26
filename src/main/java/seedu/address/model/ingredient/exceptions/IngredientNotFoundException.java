package seedu.address.model.ingredient.exceptions;

/**
 * Signals that the operation is unable to find the specified ingredient.
 */
public class IngredientNotFoundException extends RuntimeException {
    public IngredientNotFoundException() {
        super("Ingredient entered cannot be found from the ingredient book");
    }
}
