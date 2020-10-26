package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

//import seedu.address.model.AddressBook;
import seedu.address.model.IngredientBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
//import seedu.address.model.ReadOnlyIngredientBook;
import seedu.address.model.SalesBook;
import seedu.address.model.SalesTimeBook;
import seedu.address.model.UserPrefs;
import seedu.address.model.ingredient.Amount;


/**
 * Contains integration tests (interaction with the Model) and unit tests for SetAllCommand.
 */
class SetAllCommandTest {

    private static final Amount MILK_AMOUNT = new Amount("10");
    private static final Amount PEARL_AMOUNT = new Amount("10");
    private static final Amount BOBA_AMOUNT = new Amount("10");
    private static final Amount BLACK_TEA_AMOUNT = new Amount("10");
    private static final Amount GREEN_TEA_AMOUNT = new Amount("10");
    private static final Amount BROWN_SUGAR_AMOUNT = new Amount("10");
    private static final IngredientBook stubBook = new IngredientBook();
    private static final IngredientBook filledBook = new IngredientBook();


    private Model model = new ModelManager(getTypicalAddressBook(), new SalesBook(),
            new SalesTimeBook(),
            new IngredientBook(), new UserPrefs());

    /*
    @Test
    public void execute_allFieldsSpecified_success() {

        SetAllCommand setAllCommand = new SetAllCommand(MILK_AMOUNT, PEARL_AMOUNT,
                BOBA_AMOUNT, BLACK_TEA_AMOUNT, GREEN_TEA_AMOUNT, BROWN_SUGAR_AMOUNT);

        stubBook.addIngredient(new Ingredient(new IngredientName("Milk")));
        stubBook.addIngredient(new Ingredient(new IngredientName("Pearl")));
        stubBook.addIngredient(new Ingredient(new IngredientName("Boba")));
        stubBook.addIngredient(new Ingredient(new IngredientName("Black Tea")));
        stubBook.addIngredient(new Ingredient(new IngredientName("Green Tea")));
        stubBook.addIngredient(new Ingredient(new IngredientName("Brown Sugar")));

        stubBook.setIngredient(new Ingredient(new IngredientName("Milk")),
                new Ingredient(new IngredientName("Milk"), new Amount("10")));
        stubBook.setIngredient(new Ingredient(new IngredientName("Pearl")),
                new Ingredient(new IngredientName("Pearl"), new Amount("10")));
        stubBook.setIngredient(new Ingredient(new IngredientName("Boba")),
                new Ingredient(new IngredientName("Boba"), new Amount("10")));
        stubBook.setIngredient(new Ingredient(new IngredientName("Black Tea")),
                new Ingredient(new IngredientName("Black Tea"), new Amount("10")));
        stubBook.setIngredient(new Ingredient(new IngredientName("Green Tea")),
                new Ingredient(new IngredientName("Green Tea"), new Amount("10")));
        stubBook.setIngredient(new Ingredient(new IngredientName("Brown Sugar")),
                new Ingredient(new IngredientName("Brown Sugar"), new Amount("10")));

        ReadOnlyIngredientBook readOnlyToSet = stubBook;

        String expectedMessage = String.format(SetAllCommand.MESSAGE_SUCCESS, stubBook);

        Model expectedModel =
                new ModelManager(new AddressBook(model.getAddressBook()), model.getSalesBook(),
                        model.getSalesTimeBook(),
                        model.getIngredientBook(), new UserPrefs());

        expectedModel.setIngredientBook(readOnlyToSet);

        filledBook.addIngredient(new Ingredient(new IngredientName("Milk")));
        filledBook.addIngredient(new Ingredient(new IngredientName("Pearl")));
        filledBook.addIngredient(new Ingredient(new IngredientName("Boba")));
        filledBook.addIngredient(new Ingredient(new IngredientName("Black Tea")));
        filledBook.addIngredient(new Ingredient(new IngredientName("Green Tea")));
        filledBook.addIngredient(new Ingredient(new IngredientName("Brown Sugar")));
        model.setIngredientBook(filledBook);

        assertCommandSuccess(setAllCommand, model, expectedMessage, expectedModel);
    }
    */

    @Test
    public void equals() {
        final SetAllCommand standardCommand = new SetAllCommand(MILK_AMOUNT, PEARL_AMOUNT,
                BOBA_AMOUNT, BLACK_TEA_AMOUNT, GREEN_TEA_AMOUNT, BROWN_SUGAR_AMOUNT);

        // same values -> returns true
        SetAllCommand commandWithSameValues = new SetAllCommand(MILK_AMOUNT, PEARL_AMOUNT,
                BOBA_AMOUNT, BLACK_TEA_AMOUNT, GREEN_TEA_AMOUNT, BROWN_SUGAR_AMOUNT);

        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different index -> returns false
        assertFalse(standardCommand.equals(new SetAllCommand(new Amount("30"), PEARL_AMOUNT,
                BOBA_AMOUNT, BLACK_TEA_AMOUNT, GREEN_TEA_AMOUNT, BROWN_SUGAR_AMOUNT)));

    }

}
