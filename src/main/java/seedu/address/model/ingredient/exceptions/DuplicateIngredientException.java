package seedu.address.model.ingredient.exceptions;

/**
 * Signals that the operation will result in duplicate Ingredients (Ingredients are considered duplicates if
 * they have the same identity).
 */
public class DuplicateIngredientException extends RuntimeException {
    public DuplicateIngredientException() {
        super("Operation would result in duplicate ingredients");
    }
}

