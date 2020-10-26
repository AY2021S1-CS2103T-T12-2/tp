package seedu.address.logic.commands.ingredientcommands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ingredient.Ingredient;

/**
 * Set the level of one specific ingredient to a specific level.
 */
public class IngredientListCommand extends Command {

    public static final char LINE_SEPARATOR = '\n';

    public static final String COMMAND_WORD = "i-list";

    public static final String MESSAGE_USAGE = COMMAND_WORD + " :list the ingredient levels in tCheck."
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Here is the list of all ingredients: \n";
    private String ingredientList = "";

    /**
     * Constructs an Ingredient List command.
     */
    public IngredientListCommand() {
        super();
    }

    /**
     * Executes the command and returns the result message.
     *
     * @param model {@code Model} which the command should operate on.
     * @return feedback message of the operation result for display
     * @throws CommandException If an error occurs during command execution.
     */
    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        List<Ingredient> lastShownList = model.getFilteredIngredientList();
        for (Ingredient i : lastShownList) {
            ingredientList += i.toString() + LINE_SEPARATOR;
        }
        return new CommandResult(MESSAGE_SUCCESS + ingredientList);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof IngredientListCommand)) {
            return false;
        }
        return true;
    }

}
