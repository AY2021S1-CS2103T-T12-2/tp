package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BLACK_TEA;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BOBA;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BROWN_SUGAR;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GREEN_TEA;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MILK;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PEARL;

import java.util.stream.Stream;

import seedu.address.logic.commands.SetAllCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.ingredient.Amount;

public class SetAllCommandParser implements Parser<SetAllCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the SetAllCommand
     * and returns an SetAllCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public SetAllCommand parse(String args) throws ParseException {

        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_MILK, PREFIX_PEARL,
                        PREFIX_BOBA, PREFIX_BLACK_TEA, PREFIX_GREEN_TEA, PREFIX_BROWN_SUGAR);

        if (!arePrefixesPresent(argMultimap, PREFIX_MILK, PREFIX_PEARL, PREFIX_BOBA,
                PREFIX_BLACK_TEA, PREFIX_GREEN_TEA, PREFIX_BROWN_SUGAR)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, SetAllCommand.MESSAGE_USAGE));
        }

        Amount milkAmount = ParserUtil.parseAmount(argMultimap.getValue(PREFIX_MILK).get());
        Amount pearlAmount = ParserUtil.parseAmount(argMultimap.getValue(PREFIX_PEARL).get());
        Amount bobaAmount = ParserUtil.parseAmount(argMultimap.getValue(PREFIX_BOBA).get());
        Amount blackTeaAmount = ParserUtil.parseAmount(argMultimap.getValue(PREFIX_BLACK_TEA).get());
        Amount greenTeaAmount = ParserUtil.parseAmount(argMultimap.getValue(PREFIX_GREEN_TEA).get());
        Amount brownSugarAmount = ParserUtil.parseAmount(argMultimap.getValue(PREFIX_BROWN_SUGAR).get());

        return new SetAllCommand(milkAmount, pearlAmount, bobaAmount, blackTeaAmount, greenTeaAmount, brownSugarAmount);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
