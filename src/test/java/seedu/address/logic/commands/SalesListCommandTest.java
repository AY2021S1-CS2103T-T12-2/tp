package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Drink;
import seedu.address.model.IngredientBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.SalesBook;
import seedu.address.model.SalesRecordEntry;
import seedu.address.model.SalesTimeBook;
import seedu.address.model.UserPrefs;

public class SalesListCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new SalesBook(), new SalesTimeBook(),
                new IngredientBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), model.getSalesBook(), model.getSalesTimeBook(),
                model.getIngredientBook(), new UserPrefs());
    }

    @Test
    public void execute_emptySalesBook_displaysNoItemPresentMessage() {
        assertCommandSuccess(new SalesListCommand(), model, SalesListCommand.MESSAGE_NO_RECORD_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptySalesBook_successMessage() {
        SalesRecordEntry entry = new SalesRecordEntry(Drink.BSBGT, 30);
        List<SalesRecordEntry> newList = Collections.singletonList(entry);
        model.getSalesBook().setRecord(newList);
        expectedModel = new ModelManager(model.getAddressBook(), model.getSalesBook(), model.getSalesTimeBook(),
                model.getIngredientBook(), new UserPrefs());
        String expectedMessage = String.format(SalesListCommand.MESSAGE_SUCCESS, model.getSalesBook());
        assertCommandSuccess(new SalesListCommand(), model, expectedMessage, expectedModel);
    }


}
