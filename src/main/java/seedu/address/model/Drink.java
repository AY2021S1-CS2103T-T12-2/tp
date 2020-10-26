package seedu.address.model;

import static java.util.Objects.requireNonNull;

/**
 * Represents the types of drink items available.
 */
public enum Drink {
    BSBM ("Brown Sugar Boba Milk"),
    BSBBT ("Brown Sugar Boba Black Tea"),
    BSBGT ("Brown Sugar Boba Green Tea"),
    BSPM ("Brown Sugar Pearl Milk"),
    BSPBT ("Brown Sugar Pearl Black Tea"),
    BSPGT ("Brown Sugar Pearl Green Tea");

    public static final String MESSAGE_CONSTRAINTS =
            "Drink Names should only be chosen from the given list,"
                    + " and it should not be blank";

    // TODO: drink ingredients?
    private final String name;


    Drink(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getShortFormName() {
        String shortFromName = "";
        for (int i = 0; i < name.length(); i++) {
            if (Character.isUpperCase(name.charAt(i))) {
                shortFromName += name.charAt(i);
            }
        }
        return shortFromName;
    }

    /**
     * Returns true if the given drink is a valid drink name.
     * @param drinkToTest a given string of drink name
     */
    public static boolean isValidDrinkName(String drinkToTest) {
        requireNonNull(drinkToTest);
        for (Drink drink : Drink.values()) {
            if (drink.name().equals(drinkToTest)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the numberSoldToTest is a number in String format,
     * and return true if the number is not less then 0.
     *
     * @param numberSoldToTest numberSoldToTest in String format.
     * @return true if numberSoldToTest's value is larger or equals to 0.
     */
    public static boolean isValidNumberSold(String numberSoldToTest) {
        assert numberSoldToTest != "" : "numberSoldToTest should not be empty";
        return Integer.valueOf(numberSoldToTest) >= 0;
    }

}
