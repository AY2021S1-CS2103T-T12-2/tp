package seedu.address.model.ingredient;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

/**
 * Represents ALL ingredient that is tracked by tCheck.
 * OOP development plan : Each ingredient can be extracted out to make the design more OOP.
 */
public class Ingredient {

    // Identity field
    private final IngredientName ingredientName;

    // Data field
    private final Amount amount;


    /**
     * Constructs an ingredient with the given amount and ingredient name.
     * Note that the ingredient name can only be one of the static
     * String constant declared in this class.
     *
     * @param amount         an integer representing the level of the ingredient
     * @param ingredientName name of the ingredient
     */
    public Ingredient(IngredientName ingredientName, Amount amount) {
        requireAllNonNull(ingredientName, amount);
        this.amount = amount;
        this.ingredientName = ingredientName;
    }

    /**
     * Constructs an ingredient with the given name.
     * Amount is set to 0 by default.
     *
     * @param ingredientName name of the ingredient
     */
    public Ingredient(IngredientName ingredientName) {
        this.amount = new Amount("0");
        this.ingredientName = ingredientName;
    }

    public Amount getAmount() {
        return this.amount;
    }

    public IngredientName getIngredientName() {
        return this.ingredientName;
    }
    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    public boolean isSameIngredient(Ingredient otherIngredient) {
        if (otherIngredient == this) {
            return true;
        }

        return otherIngredient != null
                && otherIngredient.getIngredientName().equals(getIngredientName())
                && otherIngredient.getAmount().equals(getAmount());
    }

    /**
     * Returns true if both ingredients have the same identity and data fields.
     * This defines a stronger notion of equality between two ingredients.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Ingredient)) {
            return false;
        }

        Ingredient otherIngredient = (Ingredient) other;
        return otherIngredient.getIngredientName().equals(getIngredientName())
                && otherIngredient.getAmount().equals(getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientName, amount);
    }

    @Override
    public String toString() {

        final StringBuilder builder = new StringBuilder();
        builder.append(" Ingredient: ")
                .append(getIngredientName())
                .append(", ")
                .append(" Amount: ")
                .append(getAmount())
                .append("\n");
        return builder.toString();

    }
}
