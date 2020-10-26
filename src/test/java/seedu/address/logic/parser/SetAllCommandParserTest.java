package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BLACK_TEA;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BOBA;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BROWN_SUGAR;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GREEN_TEA;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MILK;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PEARL;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.SetAllCommand;
import seedu.address.model.ingredient.Amount;

class SetAllCommandParserTest {

    private static final String MILK_AMOUNT = " " + PREFIX_MILK + "10 ";
    private static final String PEARL_AMOUNT = " " + PREFIX_PEARL + "10 ";
    private static final String BOBA_AMOUNT = " " + PREFIX_BOBA + "10 ";
    private static final String BLACK_TEA_AMOUNT = " " + PREFIX_BLACK_TEA + "10 ";
    private static final String GREEN_TEA_AMOUNT = " " + PREFIX_GREEN_TEA + "10 ";
    private static final String BROWN_SUGAR_AMOUNT = " " + PREFIX_BROWN_SUGAR + "10 ";

    private static final String MESSAGE_INVALID_FORMAT =
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, SetAllCommand.MESSAGE_USAGE);

    private SetAllCommandParser parser = new SetAllCommandParser();

    @Test
    public void parse_missingParts_failure() {
        // only field specified
        assertParseFailure(parser, MILK_AMOUNT, MESSAGE_INVALID_FORMAT);

        // all but one fields are specified
        assertParseFailure(parser, MILK_AMOUNT + PEARL_AMOUNT
                + BOBA_AMOUNT + BLACK_TEA_AMOUNT + GREEN_TEA_AMOUNT, MESSAGE_INVALID_FORMAT);

        // empty input
        assertParseFailure(parser, "", MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidPreamble_failure() {

        // invalid number being parsed as preamble
        assertParseFailure(parser, "0" + MILK_AMOUNT
                + PEARL_AMOUNT + BOBA_AMOUNT + BLACK_TEA_AMOUNT + GREEN_TEA_AMOUNT + BROWN_SUGAR_AMOUNT,
                MESSAGE_INVALID_FORMAT);

        // invalid arguments being parsed as preamble
        assertParseFailure(parser, "some random string" + MILK_AMOUNT
                + PEARL_AMOUNT + BOBA_AMOUNT + BLACK_TEA_AMOUNT + GREEN_TEA_AMOUNT + BROWN_SUGAR_AMOUNT,
                MESSAGE_INVALID_FORMAT);

        // invalid prefix being parsed as preamble
        assertParseFailure(parser, "i/ string" + MILK_AMOUNT
                + PEARL_AMOUNT + BOBA_AMOUNT + BLACK_TEA_AMOUNT + GREEN_TEA_AMOUNT + BROWN_SUGAR_AMOUNT,
                MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_allFieldsSpecified_success() {

        String userInput = MILK_AMOUNT + PEARL_AMOUNT
                + BOBA_AMOUNT + BLACK_TEA_AMOUNT + GREEN_TEA_AMOUNT + BROWN_SUGAR_AMOUNT;

        SetAllCommand expectedCommand = new SetAllCommand(new Amount("10"), new Amount("10"),
                new Amount("10"), new Amount("10"), new Amount("10"), new Amount("10"));

        assertParseSuccess(parser, userInput, expectedCommand);
    }

}
