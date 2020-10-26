package seedu.address.logic.commands;


import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.IngredientBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.ReadOnlyIngredientBook;
import seedu.address.model.SalesBook;
import seedu.address.model.SalesTimeBook;
import seedu.address.model.UserPrefs;
import seedu.address.model.ingredient.Amount;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.IngredientName;


class SetDefaultCommandTest {

    private static final IngredientBook stubBook = new IngredientBook();
    private static final IngredientBook stubBook2 = new IngredientBook();
    private static final IngredientBook filledBook = new IngredientBook();

    @Test
    public void execute_emptyIngredientBook_success() {
        Model model = new ModelManager();

        Model expectedModel = new ModelManager();

        stubBook.addIngredient(new Ingredient(new IngredientName("Milk")));
        stubBook.addIngredient(new Ingredient(new IngredientName("Pearl")));
        stubBook.addIngredient(new Ingredient(new IngredientName("Boba")));
        stubBook.addIngredient(new Ingredient(new IngredientName("Black Tea")));
        stubBook.addIngredient(new Ingredient(new IngredientName("Green Tea")));
        stubBook.addIngredient(new Ingredient(new IngredientName("Brown Sugar")));

        stubBook.setIngredient(new Ingredient(new IngredientName("Milk")),
                new Ingredient(new IngredientName("Milk"), new Amount("50")));
        stubBook.setIngredient(new Ingredient(new IngredientName("Pearl")),
                new Ingredient(new IngredientName("Pearl"), new Amount("20")));
        stubBook.setIngredient(new Ingredient(new IngredientName("Boba")),
                new Ingredient(new IngredientName("Boba"), new Amount("20")));
        stubBook.setIngredient(new Ingredient(new IngredientName("Black Tea")),
                new Ingredient(new IngredientName("Black Tea"), new Amount("50")));
        stubBook.setIngredient(new Ingredient(new IngredientName("Green Tea")),
                new Ingredient(new IngredientName("Green Tea"), new Amount("50")));
        stubBook.setIngredient(new Ingredient(new IngredientName("Brown Sugar")),
                new Ingredient(new IngredientName("Brown Sugar"), new Amount("20")));

        ReadOnlyIngredientBook defaultReadOnlyIngredientBook = stubBook;
        expectedModel.setIngredientBook(defaultReadOnlyIngredientBook);

        assertCommandSuccess(new SetDefaultCommand(), model, SetDefaultCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptyIngredientBook_success() {

        filledBook.addIngredient(new Ingredient(new IngredientName("Milk")));
        filledBook.addIngredient(new Ingredient(new IngredientName("Pearl")));
        filledBook.addIngredient(new Ingredient(new IngredientName("Boba")));
        filledBook.addIngredient(new Ingredient(new IngredientName("Black Tea")));
        filledBook.addIngredient(new Ingredient(new IngredientName("Green Tea")));
        filledBook.addIngredient(new Ingredient(new IngredientName("Brown Sugar")));

        Model model = new ModelManager(getTypicalAddressBook(), new SalesBook(), new SalesTimeBook(),
                filledBook, new UserPrefs());


        model.setIngredient(new Ingredient(new IngredientName("Milk")),
                new Ingredient(new IngredientName("Milk"), new Amount("100")));
        model.setIngredient(new Ingredient(new IngredientName("Pearl")),
                new Ingredient(new IngredientName("Pearl"), new Amount("120")));

        Model expectedModel = new ModelManager(getTypicalAddressBook(), new SalesBook(), new SalesTimeBook(),
                stubBook2, new UserPrefs());

        stubBook2.addIngredient(new Ingredient(new IngredientName("Milk")));
        stubBook2.addIngredient(new Ingredient(new IngredientName("Pearl")));
        stubBook2.addIngredient(new Ingredient(new IngredientName("Boba")));
        stubBook2.addIngredient(new Ingredient(new IngredientName("Black Tea")));
        stubBook2.addIngredient(new Ingredient(new IngredientName("Green Tea")));
        stubBook2.addIngredient(new Ingredient(new IngredientName("Brown Sugar")));

        stubBook2.setIngredient(new Ingredient(new IngredientName("Milk")),
                new Ingredient(new IngredientName("Milk"), new Amount("50")));
        stubBook2.setIngredient(new Ingredient(new IngredientName("Pearl")),
                new Ingredient(new IngredientName("Pearl"), new Amount("20")));
        stubBook2.setIngredient(new Ingredient(new IngredientName("Boba")),
                new Ingredient(new IngredientName("Boba"), new Amount("20")));
        stubBook2.setIngredient(new Ingredient(new IngredientName("Black Tea")),
                new Ingredient(new IngredientName("Black Tea"), new Amount("50")));
        stubBook2.setIngredient(new Ingredient(new IngredientName("Green Tea")),
                new Ingredient(new IngredientName("Green Tea"), new Amount("50")));
        stubBook2.setIngredient(new Ingredient(new IngredientName("Brown Sugar")),
                new Ingredient(new IngredientName("Brown Sugar"), new Amount("20")));

        ReadOnlyIngredientBook defaultReadOnlyIngredientBook = stubBook2;

        expectedModel.setIngredientBook(defaultReadOnlyIngredientBook);

        assertCommandSuccess(new SetDefaultCommand(), model, SetDefaultCommand.MESSAGE_SUCCESS, expectedModel);
    }

}
