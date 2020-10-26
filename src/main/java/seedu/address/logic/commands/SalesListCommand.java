package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Lists the sales of the drink items that has been recorded by the app.
 */
public class SalesListCommand extends Command {

    public static final String COMMAND_WORD = "s-list";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Lists the sales of the drinks as entered. "
            + "Parameters: There are no parameters.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Listed the sales that has been recorded.";

    public static final String MESSAGE_NO_RECORD_SUCCESS = "You have not recorded any sales yet. Use "
            + SalesUpdateCommand.COMMAND_WORD + " to update the sales record.";

    /**
     * Executes the command and returns the result message.
     *
     * @param model {@code Model} which the command should operate on.
     * @return feedback message of the operation result for display
     * @throws CommandException If an error occurs during command execution.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        // TODO: with UI need to update model with the salesBook ui
        if (model.isEmptySalesBook()) {
            return new CommandResult(MESSAGE_NO_RECORD_SUCCESS);
        } else {
            return new CommandResult(MESSAGE_SUCCESS);
        }
    }

}
