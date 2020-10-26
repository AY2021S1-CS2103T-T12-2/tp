package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_AMOUNT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INGREDIENT;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_INGREDIENTS;

import java.util.List;
import java.util.Optional;

import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ingredient.Amount;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.IngredientName;

/**
 * Set the level of one specific ingredient to a specific level.
 */
public class SetCommand extends Command {

    public static final String COMMAND_WORD = "i-set";

    public static final String MESSAGE_USAGE = COMMAND_WORD + " :set the ingredient in tCheck."
            + "Parameters: "
            + PREFIX_INGREDIENT
            + PREFIX_AMOUNT
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_INGREDIENT + "Milk "
            + PREFIX_AMOUNT + "90 ";

    public static final String MESSAGE_SUCCESS = "Ingredient set: %1$s";
    public static final String MESSAGE_NO_CHANGE = "Ingredient level already set.";
    public static final String MESSAGE_NOT_FOUND = "Ingredient not found in ingredient book.";
    private final IngredientName targetName;
    private final SetIngredientDescriptor setIngredientDescriptor;

    /**
     * Constructs a set command with the given ingredient name and amount.
     */
    public SetCommand(IngredientName targetName, SetIngredientDescriptor setIngredientDescriptor) {
        requireNonNull(targetName);
        requireNonNull(setIngredientDescriptor);

        this.targetName = targetName;
        this.setIngredientDescriptor = setIngredientDescriptor;

    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Ingredient> lastShownList = model.getFilteredIngredientList();

        Ingredient ingredientToEdit = null;
        boolean isNoChange = false;

        for (Ingredient ingredient : lastShownList) {
            if (ingredient.getIngredientName().equals(targetName)) {
                ingredientToEdit = ingredient;

            }
        }

        if (ingredientToEdit == null) {
            throw new CommandException(MESSAGE_NOT_FOUND);
        }

        if (ingredientToEdit.getAmount().equals(setIngredientDescriptor.getAmount().get())) {
            isNoChange = true;
        }

        Ingredient updatedIngredient = createSetIngredient(ingredientToEdit, setIngredientDescriptor);

        if (isNoChange) {
            throw new CommandException(MESSAGE_NO_CHANGE);
        }


        model.setIngredient(ingredientToEdit, updatedIngredient);
        model.updateFilteredIngredientList(PREDICATE_SHOW_ALL_INGREDIENTS);

        return new CommandResult(String.format(MESSAGE_SUCCESS, updatedIngredient));
    }

    private static Ingredient createSetIngredient(Ingredient target,
                                                  SetIngredientDescriptor setIngredientDescriptor) {
        assert target != null;

        Amount updatedAmount = setIngredientDescriptor.getAmount().orElse(target.getAmount());

        return new Ingredient(target.getIngredientName(), updatedAmount);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SetCommand)) {
            return false;
        }

        SetCommand e = (SetCommand) other;

        return targetName.equals(e.targetName)
                && setIngredientDescriptor.equals(e.setIngredientDescriptor);
    }

    public static class SetIngredientDescriptor {

        private IngredientName ingredientName;
        private Amount amount;

        public SetIngredientDescriptor(){}

        /**
         * Copy constructor.
         */
        public SetIngredientDescriptor(SetIngredientDescriptor toCopy) {
            setAmount(toCopy.amount);
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(amount);
        }

        public void setAmount(Amount amount) {
            this.amount = amount;
        }
        public Optional<IngredientName> getIngredientName() {
            return Optional.ofNullable(ingredientName);
        }
        public Optional<Amount> getAmount() {
            return Optional.ofNullable(amount);
        }

        @Override
        public boolean equals(Object other) {
            // short circuit if same object
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof SetCommand.SetIngredientDescriptor)) {
                return false;
            }

            // state check
            SetCommand.SetIngredientDescriptor e = (SetCommand.SetIngredientDescriptor) other;

            return getIngredientName().equals(e.getIngredientName())
                    && getAmount().equals(e.getAmount());
        }
    }
}
