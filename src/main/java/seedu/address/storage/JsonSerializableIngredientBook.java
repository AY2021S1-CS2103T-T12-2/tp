package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.IngredientBook;
import seedu.address.model.ReadOnlyIngredientBook;
import seedu.address.model.ingredient.Ingredient;

/**
 * An Immutable IngredientBook that is serializable to JSON format.
 */
@JsonRootName(value = "ingredientbook")
class JsonSerializableIngredientBook {

    public static final String MESSAGE_DUPLICATE_INGREDIENT = "Ingredient list contains duplicate ingredient(s).";

    private final List<JsonAdaptedIngredient> ingredients = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableIngredientBook} with the given ingredients.
     */
    @JsonCreator
    public JsonSerializableIngredientBook(@JsonProperty("ingredients") List<JsonAdaptedIngredient> ingredients) {
        this.ingredients.addAll(ingredients);
    }

    /**
     * Converts a given {@code ReadOnlyIngredientBook} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableIngredientBook}.
     */
    public JsonSerializableIngredientBook(ReadOnlyIngredientBook source) {
        ingredients.addAll(source.getIngredientList().stream().map(JsonAdaptedIngredient::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this address book into the model's {@code IngredientBook} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public IngredientBook toModelType() throws IllegalValueException {
        IngredientBook ingredientBook = new IngredientBook();
        for (JsonAdaptedIngredient jsonAdaptedIngredient : ingredients) {
            Ingredient ingredient = jsonAdaptedIngredient.toModelType();
            if (ingredientBook.hasIngredient(ingredient)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_INGREDIENT);
            }
            ingredientBook.addIngredient(ingredient);
        }
        return ingredientBook;
    }

}

