package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.IngredientBook;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyIngredientBook;
import seedu.address.model.ingredient.Amount;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.IngredientName;

/**
 * Set the ingredient to the default levels.
 */
public class SetDefaultCommand extends Command {

    public static final String LINE_SEPARATOR = "\n";
    public static final String COMMAND_WORD = "i-set-default";
    public static final String MESSAGE_SUCCESS = "All ingredients have been set to the default level:" + LINE_SEPARATOR
            + "Milk : 50 L" + LINE_SEPARATOR
            + "Pearl : 20 KG" + LINE_SEPARATOR
            + "Boba : 20 KG" + LINE_SEPARATOR
            + "Black Tea : 50 L" + LINE_SEPARATOR
            + "Green Tea : 50 L" + LINE_SEPARATOR
            + "Brown Sugar : 20 KG" + LINE_SEPARATOR;

    @Override
    public CommandResult execute(Model model) {

        requireNonNull(model);

        IngredientBook defaultIngredientBook = new IngredientBook();
        IngredientBook filledBook = executeHelper(defaultIngredientBook);

        filledBook.setIngredient(new Ingredient(new IngredientName("Milk")),
                new Ingredient(new IngredientName("Milk"), new Amount("50")));
        filledBook.setIngredient(new Ingredient(new IngredientName("Pearl")),
                new Ingredient(new IngredientName("Pearl"), new Amount("20")));
        filledBook.setIngredient(new Ingredient(new IngredientName("Boba")),
                new Ingredient(new IngredientName("Boba"), new Amount("20")));
        filledBook.setIngredient(new Ingredient(new IngredientName("Black Tea")),
                new Ingredient(new IngredientName("Black Tea"), new Amount("50")));
        filledBook.setIngredient(new Ingredient(new IngredientName("Green Tea")),
                new Ingredient(new IngredientName("Green Tea"), new Amount("50")));
        filledBook.setIngredient(new Ingredient(new IngredientName("Brown Sugar")),
                new Ingredient(new IngredientName("Brown Sugar"), new Amount("20")));

        ReadOnlyIngredientBook defaultReadOnlyFilledBook = filledBook;

        model.setIngredientBook(defaultReadOnlyFilledBook);
        model.updateFilteredIngredientList(Model.PREDICATE_SHOW_ALL_INGREDIENTS);

        return new CommandResult(MESSAGE_SUCCESS);
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
}
