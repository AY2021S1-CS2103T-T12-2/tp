/* package seedu.address.logic.commands.ingredientcommands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ClearCommand;
import seedu.address.model.IngredientBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.ReadOnlyIngredientBook;
import seedu.address.model.ingredient.Amount;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.IngredientName;

public class IngredientViewSingleCommandTest {


    @Test
    public void execute_viewIngredient_success() {
        Model model = new ModelManager();
        Model expectedModel = model;
        Amount amount = new Amount ("10");

        IngredientBook defaultBook = new IngredientBook();
        defaultBook.addIngredient(new Ingredient(new IngredientName("Milk"), amount));
        defaultBook.addIngredient(new Ingredient(new IngredientName("Pearl"), amount));
        defaultBook.addIngredient(new Ingredient(new IngredientName("Boba"), amount));
        defaultBook.addIngredient(new Ingredient(new IngredientName("Black Tea"), amount));
        defaultBook.addIngredient(new Ingredient(new IngredientName("Green Tea"), amount));
        defaultBook.addIngredient(new Ingredient(new IngredientName("Brown Sugar"), amount));
        ReadOnlyIngredientBook readOnlyIngredientBook = defaultBook;

        model.setIngredientBook(readOnlyIngredientBook);

        IngredientBook original = new IngredientBook();
        original.addIngredient(new Ingredient(new IngredientName("Milk"), amount));
        original.addIngredient(new Ingredient(new IngredientName("Pearl"), amount));
        original.addIngredient(new Ingredient(new IngredientName("Boba"), amount));
        original.addIngredient(new Ingredient(new IngredientName("Black Tea"), amount));
        original.addIngredient(new Ingredient(new IngredientName("Green Tea"), amount));
        original.addIngredient(new Ingredient(new IngredientName("Brown Sugar"), amount));
        ReadOnlyIngredientBook defaultReadOnlyIngredientBook = original;

        expectedModel.setIngredientBook(defaultReadOnlyIngredientBook);

        IngredientViewSingleCommand.ViewIngredientDescriptor descriptor = new
                IngredientViewSingleCommand.ViewIngredientDescriptor();
        final IngredientViewSingleCommand standardCommand = new
                IngredientViewSingleCommand(new IngredientName("Milk"), descriptor);
        final String messageSuccess = "Here is the ingredient and its level: "
                + new Ingredient(new IngredientName("Milk"), amount).toString();
        assertCommandSuccess(standardCommand, model, messageSuccess, expectedModel);

    }

    @Test
    public void equals() {
        IngredientViewSingleCommand.ViewIngredientDescriptor descriptor = new
                IngredientViewSingleCommand.ViewIngredientDescriptor();
        final IngredientViewSingleCommand standardCommand = new
                IngredientViewSingleCommand(new IngredientName("Milk"), descriptor);

        // same values -> returns true
        IngredientViewSingleCommand commandWithSameValues = new
                IngredientViewSingleCommand(new IngredientName("Milk"), descriptor);
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different ingredient names -> returns false
        IngredientViewSingleCommand commandWithDifferentValues = new
                IngredientViewSingleCommand(new IngredientName("Boba"), descriptor);
        assertFalse(standardCommand.equals(commandWithDifferentValues));

    }

}*/
