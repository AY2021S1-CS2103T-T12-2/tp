package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions for contacts */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMERGENCY = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");

    /* Prefix definitions for ingredients */
    public static final Prefix PREFIX_INGREDIENT = new Prefix("i/");
    public static final Prefix PREFIX_AMOUNT = new Prefix("m/");
    public static final Prefix PREFIX_MILK = new Prefix("M/");
    public static final Prefix PREFIX_PEARL = new Prefix("P/");
    public static final Prefix PREFIX_BOBA = new Prefix("B/");
    public static final Prefix PREFIX_BLACK_TEA = new Prefix("L/");
    public static final Prefix PREFIX_GREEN_TEA = new Prefix("G/");
    public static final Prefix PREFIX_BROWN_SUGAR = new Prefix("S/");

    /* Prefix definitions for drinks */
    public static final Prefix PREFIX_BSBM = new Prefix("BSBM/");
    public static final Prefix PREFIX_BSBBT = new Prefix("BSBBT/");
    public static final Prefix PREFIX_BSBGT = new Prefix("BSBGT/");
    public static final Prefix PREFIX_BSPM = new Prefix("BSPM/");
    public static final Prefix PREFIX_BSPBT = new Prefix("BSPBT/");
    public static final Prefix PREFIX_BSPGT = new Prefix("BSPGT/");

}
