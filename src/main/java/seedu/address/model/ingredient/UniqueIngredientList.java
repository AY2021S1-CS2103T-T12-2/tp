package seedu.address.model.ingredient;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.ingredient.exceptions.DuplicateIngredientException;
import seedu.address.model.ingredient.exceptions.IngredientNotFoundException;
import seedu.address.model.ingredient.exceptions.NoChangeIngredientException;

public class UniqueIngredientList implements Iterable<Ingredient> {

    private final ObservableList<Ingredient> internalList = FXCollections.observableArrayList();

    private final ObservableList<Ingredient> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    /**
     * Returns true if an ingredient with the same identity as {@code ingredient} exists in the ingredient book.
     */
    public boolean contains(Ingredient toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameIngredient);
    }

    public void setIngredient(Ingredient target, Ingredient newAmount) {

        requireAllNonNull(target, newAmount);

        int index = internalList.indexOf(target);

        if (index == -1) {
            throw new IngredientNotFoundException();
        }

        if (internalList.contains(newAmount)) {
            throw new NoChangeIngredientException();
        }

        internalList.set(index, newAmount);
    }

    public void setIngredients(UniqueIngredientList replacement) {
        requireNonNull(replacement);

        internalList.setAll(replacement.internalList);
    }

    public void setIngredients(List<Ingredient> ingredients) {
        requireAllNonNull(ingredients);
        if (!ingredientsAreUnique(ingredients)) {
            throw new NoChangeIngredientException();
        }
        internalList.setAll(ingredients);
    }

    /**
     * Returns the ingredient with the input ingredient name, if
     * not found, return null.
     *
     * @param ingredientName ingredient name
     * @return ingredient with the input ingredient name
     */
    public Ingredient findIngredientByName(IngredientName ingredientName) {
        requireNonNull(ingredientName);
        for (int i = 0; i < internalList.size() - 1; i++) {
            if (internalList.get(i).getIngredientName().equals(ingredientName)) {
                return internalList.get(i);
            }
        }
        return null;
    }

    public ObservableList<Ingredient> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    public int size() {
        return internalList.size();
    }

    public Ingredient get(int index) {
        return internalList.get(index);
    }

    @Override
    public Iterator<Ingredient> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniqueIngredientList // instanceof handles nulls
                && internalList.equals(((UniqueIngredientList) other).internalList));
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

    private boolean ingredientsAreUnique(List<Ingredient> ingredients) {
        for (int i = 0; i < ingredients.size() - 1; i++) {
            for (int j = i + 1; j < ingredients.size(); j++) {
                if (ingredients.get(i).isSameIngredient(ingredients.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * Adds an ingredient to the list.
     * The ingredient must not already exist in the list.
     */
    public void add(Ingredient toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicateIngredientException();
        }
        internalList.add(toAdd);
    }
}

