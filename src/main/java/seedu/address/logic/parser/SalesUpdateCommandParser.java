package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BSBBT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BSBGT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BSBM;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BSPBT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BSPGT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BSPM;

import java.util.HashMap;
import java.util.Optional;

import seedu.address.logic.commands.SalesUpdateCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Drink;

/**
 * Parses input arguments and creates a new SalesUpdateCommand object
 */
public class SalesUpdateCommandParser implements Parser<SalesUpdateCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the SalesUpdateCommand
     * and returns a SalesUpdateCommand object for execution.
     *
     * The default value is 0 for drink items which the user did not provide the input.
     *
     * @param args user input to parse
     * @return a SalesUpdateCommand object for execution
     * @throws ParseException if {@code userInput} does not conform the expected format
     */
    @Override
    public SalesUpdateCommand parse(String args) throws ParseException {
        requireNonNull(args);
        Prefix[] drinkPrefixes =
                new Prefix[] {PREFIX_BSBM, PREFIX_BSBBT, PREFIX_BSBGT, PREFIX_BSPM, PREFIX_BSPBT, PREFIX_BSPGT};
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, drinkPrefixes);

        int drinkCounter = 0;
        HashMap<Drink, Integer> sales = new HashMap<>();
        // populate the map with argmultimap's values
        for (int i = 0; i < drinkPrefixes.length; i++) {
            Optional<String> numSold = argMultimap.getValue(drinkPrefixes[i]);
            String value = numSold.orElse("0");
            int intValue = ParserUtil.parseNumberSold(value);

            if (intValue > 0) {
                drinkCounter++;
            }

            Drink drink = Drink.valueOf(drinkPrefixes[i].toString().replace("/", ""));
            sales.put(drink, intValue);
        }

        if (drinkCounter == 0) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, SalesUpdateCommand.MESSAGE_USAGE));
        }

        assert !sales.isEmpty();

        return new SalesUpdateCommand(sales);
    }
}
