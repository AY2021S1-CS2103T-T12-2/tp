package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BLACK_TEA;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BOBA;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BROWN_SUGAR;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GREEN_TEA;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MILK;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PEARL;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.IngredientBook;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyIngredientBook;
import seedu.address.model.ingredient.Amount;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.IngredientName;

/**
 * Set all ingredients in the ingredient book to different specified amounts.
 */
public class SetAllCommand extends Command {

    public static final String COMMAND_WORD = "i-set-all";

    public static final String LINE_SEPARATOR = "\n";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sets all ingredients to specified amounts "
            + "in the ingredient book. " + LINE_SEPARATOR
            + "Parameters: " + LINE_SEPARATOR
            + PREFIX_MILK + "AMOUNT_FOR_MILK "
            + PREFIX_PEARL + "AMOUNT_FOR_PEARL "
            + PREFIX_BOBA + "AMOUNT_FOR_BOBA "
            + PREFIX_BLACK_TEA + "AMOUNT_FOR_BLACK_TEA "
            + PREFIX_GREEN_TEA + "AMOUNT_FOR_GREEN_TEA "
            + PREFIX_BROWN_SUGAR + "AMOUNT_FOR_BROWN_SUGAR " + LINE_SEPARATOR
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_MILK + "90 "
            + PREFIX_PEARL + "90 "
            + PREFIX_BOBA + "30 "
            + PREFIX_BLACK_TEA + "40 "
            + PREFIX_GREEN_TEA + "30 "
            + PREFIX_BROWN_SUGAR + "10";

    public static final String MESSAGE_NO_CHANGE = "All current amounts have already been "
            + "set to the specified amounts";

    public static final String MESSAGE_SUCCESS = "Ingredient book has been set : %1$s" + LINE_SEPARATOR;

    private final Amount milkAmount;
    private final Amount pearlAmount;
    private final Amount bobaAmount;
    private final Amount blackTeaAmount;
    private final Amount greenTeaAmount;
    private final Amount brownSugarAmount;

    /**
     * Constructs a set all command with the given amounts for all different ingredients.
     */
    public SetAllCommand(Amount milkAmount, Amount pearlAmount, Amount bobaAmount,
                         Amount blackTeaAmount, Amount greenTeaAmount, Amount brownSugarAmount) {
        requireAllNonNull(milkAmount, pearlAmount, bobaAmount, blackTeaAmount, greenTeaAmount, brownSugarAmount);
        this.milkAmount = milkAmount;
        this.pearlAmount = pearlAmount;
        this.bobaAmount = bobaAmount;
        this.blackTeaAmount = blackTeaAmount;
        this.greenTeaAmount = greenTeaAmount;
        this.brownSugarAmount = brownSugarAmount;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        IngredientBook toSet = new IngredientBook();
        IngredientBook filledBook = executeHelper(toSet);

        boolean isNoChange = milkAmount.equals(model.findIngredientByName(new IngredientName("Milk")).getAmount())
                && pearlAmount.equals(model.findIngredientByName(new IngredientName("Pearl")).getAmount())
                && bobaAmount.equals(model.findIngredientByName(new IngredientName("Boba")).getAmount())
                && blackTeaAmount.equals(model.findIngredientByName(new IngredientName("Black Tea")).getAmount())
                && greenTeaAmount.equals(model.findIngredientByName(new IngredientName("Green Tea")).getAmount())
                && brownSugarAmount.equals(model.findIngredientByName(new IngredientName("Brown Sugar")).getAmount());

        if (isNoChange) {
            throw new CommandException(MESSAGE_NO_CHANGE);
        }

        filledBook.setIngredient(new Ingredient(new IngredientName("Milk")),
                new Ingredient(new IngredientName("Milk"), milkAmount));
        filledBook.setIngredient(new Ingredient(new IngredientName("Pearl")),
                new Ingredient(new IngredientName("Pearl"), pearlAmount));
        filledBook.setIngredient(new Ingredient(new IngredientName("Boba")),
                new Ingredient(new IngredientName("Boba"), bobaAmount));
        filledBook.setIngredient(new Ingredient(new IngredientName("Black Tea")),
                new Ingredient(new IngredientName("Black Tea"), blackTeaAmount));
        filledBook.setIngredient(new Ingredient(new IngredientName("Black Tea")),
                new Ingredient(new IngredientName("Green Tea"), greenTeaAmount));
        filledBook.setIngredient(new Ingredient(new IngredientName("Brown Sugar")),
                new Ingredient(new IngredientName("Brown Sugar"), milkAmount));

        ReadOnlyIngredientBook readOnlyFilledBook = filledBook;
        model.setIngredientBook(readOnlyFilledBook);

        return new CommandResult(String.format(MESSAGE_SUCCESS, toSet));
    }

    private static IngredientBook executeHelper(IngredientBook tempBook) {

        tempBook.addIngredient(new Ingredient(new IngredientName("Milk")));
        tempBook.addIngredient(new Ingredient(new IngredientName("Pearl")));
        tempBook.addIngredient(new Ingredient(new IngredientName("Boba")));
        tempBook.addIngredient(new Ingredient(new IngredientName("Black Tea")));
        tempBook.addIngredient(new Ingredient(new IngredientName("Green Tea")));
        tempBook.addIngredient(new Ingredient(new IngredientName("Brown Sugar")));
        return tempBook;

    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SetAllCommand)) {
            return false;
        }

        SetAllCommand e = (SetAllCommand) other;

        return milkAmount.equals(e.milkAmount)
                && pearlAmount.equals(e.pearlAmount)
                && bobaAmount.equals(e.bobaAmount)
                && blackTeaAmount.equals(e.blackTeaAmount)
                && greenTeaAmount.equals(e.greenTeaAmount)
                && brownSugarAmount.equals(e.brownSugarAmount);
    }

}
