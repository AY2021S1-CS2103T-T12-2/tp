package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.ingredient.Ingredient;

public interface ReadOnlyIngredientBook {
    ObservableList<Ingredient> getIngredientList();
}
