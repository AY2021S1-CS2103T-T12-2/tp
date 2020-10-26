package seedu.address.model.ingredient;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.Arrays;

/**
 * Represents an ingredient's name in tCheck.
 */
public class IngredientName {

    public static final String MESSAGE_CONSTRAINTS =
            "Ingredient Names should only be chosen from the given list,"
                    + " and it should not be blank";

    public static final String[] INGREDIENTS = new String[]{"Milk",
        "Pearl", "Boba", "Black Tea", "Green Tea", "Brown Sugar"};


    public final String ingredientName;

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    public IngredientName(String ingredientName) {
        requireNonNull(ingredientName);
        checkArgument(isValidIngredientName(ingredientName), MESSAGE_CONSTRAINTS);
        this.ingredientName = ingredientName;
    }

    /**
     * Returns true if the given ingredientName is a valid ingredient name.
     * @param ingredientName a given string of ingredient name
     */
    public static boolean isValidIngredientName(String ingredientName) {
        requireNonNull(ingredientName);
        return Arrays.asList(INGREDIENTS).contains(ingredientName);
    }

    @Override
    public String toString() {
        return ingredientName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof IngredientName // instanceof handles nulls
                && ingredientName.equals(((IngredientName) other).ingredientName));
    }

    @Override
    public int hashCode() {
        return ingredientName.hashCode();
    }
}
