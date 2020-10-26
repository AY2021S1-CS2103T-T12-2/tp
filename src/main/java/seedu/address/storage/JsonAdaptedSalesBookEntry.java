package seedu.address.storage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.SalesBookEntry;
import seedu.address.model.UniqueSalesRecordList;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;

/**
 * Jackson-friendly version of {@link SalesBookEntry}.
 */
public class JsonAdaptedSalesBookEntry {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "SalesBookEntry's %s field is missing!";
    private final String localDate;
    private final UniqueSalesRecordList salesList;
    /**
     * Constructs a {@code JsonAdaptedSalesBookEntry} with the given salesBookEntry details.
     */
    @JsonCreator
    public JsonAdaptedSalesBookEntry(@JsonProperty("localDate") String localDate,
                                     @JsonProperty("salesRecordList")
                                         UniqueSalesRecordList salesList) {
        this.localDate = localDate;
        this.salesList = salesList;
    }

    /**
     * Converts a given {@code SalesBookEntry} into this class for Jackson use.
     */
    public JsonAdaptedSalesBookEntry(SalesBookEntry source) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        localDate = source.getLocalDate().format(formatter);
        salesList = source.getSalesRecordList();
    }

    /**
     * Converts this Jackson-friendly adapted salesBookEntry object into the model's {@code SalesBookEntry} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted salesBookEntry.
     */
    public SalesBookEntry toModelType() throws IllegalValueException {
        if (localDate == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }

        final LocalDate modelLocalDate = LocalDate.parse(localDate);

        if (salesList == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
        }

        final UniqueSalesRecordList modelSalesBook = salesList;

        return new SalesBookEntry(modelLocalDate, modelSalesBook);
    }
}
