package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import seedu.address.model.Drink;
import seedu.address.model.IngredientBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.SalesBook;
import seedu.address.model.SalesTimeBook;
import seedu.address.model.UserPrefs;

public class SalesUpdateCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new SalesBook(), new SalesTimeBook(),
            new IngredientBook(), new UserPrefs());

    @Test
    public void execute_updateOneDrinkItem_success() {
    //    final int numBsbmSold = 80;
    //    HashMap<Drink, Integer> sales = new HashMap<>();
    //    sales.put(Drink.BSBM, numBsbmSold);//sales.put(Drink.BSBBT, 0);
    //    sales.put(Drink.BSBGT, 0);
    //    sales.put(Drink.BSPM, 0);
    //    sales.put(Drink.BSPBT, 0);
    //    sales.put(Drink.BSPGT, 0);
    //
    //    SalesUpdateCommand command = new SalesUpdateCommand(sales);
    //
    //    String expectedMessage = String.format(SalesUpdateCommand.MESSAGE_SUCCESS, sales.toString());
    //    Model expectedModel =
    //            new ModelManager(new AddressBook(model.getAddressBook()), model.getSalesBook(),
    //                    model.getSalesTimeBook(),
    //                    new IngredientBook(), new UserPrefs());
    //    expectedModel.overwrite(sales);
    //
    //    LocalDate time = LocalDate.now();
    //    UniqueSalesRecordList temp = expectedModel.getSalesBook().getRecord();
    //    HashMap<LocalDate, UniqueSalesRecordList> userInput = new HashMap<>();
    //    userInput.put(time, temp);
    //    expectedModel.overwriteSalesBook(userInput);
    //    assertCommandSuccess(command, model, expectedMessage, expectedModel);
    }

    @Test
    public void equals() {
        final HashMap<Drink, Integer> standardSales = new HashMap<>();
        standardSales.put(Drink.BSBBT, 100);
        final SalesUpdateCommand standardCommand = new SalesUpdateCommand(standardSales);

        // same values -> returns true
        SalesUpdateCommand commandWithSameValues = new SalesUpdateCommand(standardSales);
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different sales -> returns false
        final HashMap<Drink, Integer> differentSales = new HashMap<>();
        differentSales.put(Drink.BSBBT, 10);
        assertFalse(standardCommand.equals(new SalesUpdateCommand(differentSales)));
    }
}
