package seedu.address.logic.commands;

import seedu.address.model.Model;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_SALES_RECORD_ENTRY;

/**
 * Ranks the drink items in the SalesBook based on the number od
 */
public class SalesListCommand extends Command {

    public static final String COMMAND_WORD = "s-list";

    public static final String MESSAGE_SUCCESS = "Listed the sales of drink items recorded in a "
            + "descending order.";

    public static final String MESSAGE_NO_RECORD_SUCCESS = "You have not recorded any sales yet. Use "
            + SalesUpdateCommand.COMMAND_WORD + " to update the sales record.";

    /**
     * Executes the command and returns the result message.
     *
     * @param model {@code Model} which the command should operate on
     * @return feedback message of the operation result for display
     */
    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        if (model.isEmptySalesBook()) {
            return new CommandResult(MESSAGE_NO_RECORD_SUCCESS);
        } else {
            model.sortSalesBook();
            model.updateFilteredSalesList(PREDICATE_SHOW_ALL_SALES_RECORD_ENTRY);
            return new CommandResult(MESSAGE_SUCCESS);
        }
    }

}
