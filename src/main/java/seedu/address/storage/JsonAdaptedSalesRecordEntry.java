package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.Drink;
import seedu.address.model.SalesRecordEntry;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;

/**
 * Jackson-friendly version of {@link SalesRecordEntry}.
 */
class JsonAdaptedSalesRecordEntry {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "SalesRecordEntry's %s field is missing!";

    private final String drink;
    private final String numberSold;

    /**
     * Constructs a {@code JsonAdaptedSalesRecordEntry} with the given salesRecordEntry details.
     */
    @JsonCreator
    public JsonAdaptedSalesRecordEntry(@JsonProperty("drink") String drink,
                                       @JsonProperty("numberSold") String numberSold) {

        this.drink = drink;
        this.numberSold = numberSold;
    }

    /**
     * Converts a given {@code SalesRecordEntry} into this class for Jackson use.
     */
    public JsonAdaptedSalesRecordEntry(SalesRecordEntry source) {
        drink = source.getDrink().getShortFormName();
        numberSold = String.valueOf(source.getNumberSold());
    }

    /**
     * Converts this Jackson-friendly adapted salesRecordEntry object into the model's {@code SalesRecordEntry} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted salesRecordEntry.
     */
    public SalesRecordEntry toModelType() throws IllegalValueException {
        if (drink == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Drink.isValidDrinkName(drink)) {
            throw new IllegalValueException(Drink.MESSAGE_CONSTRAINTS);
        }
        final Drink modelDrinkName = Drink.valueOf(drink);

        if (numberSold == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
        }
        if (!Drink.isValidNumberSold(numberSold)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Integer modelNumberSold = Integer.valueOf(numberSold);

        return new SalesRecordEntry(modelDrinkName, modelNumberSold);

    }

}
