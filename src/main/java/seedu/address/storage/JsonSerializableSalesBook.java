package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.ReadOnlySalesBook;
import seedu.address.model.SalesBook;
import seedu.address.model.SalesRecordEntry;

/**
 * An Immutable SalesBook that is serializable to JSON format.
 */
@JsonRootName(value = "salesbook")
class JsonSerializableSalesBook {

    public static final String MESSAGE_DUPLICATE_SALESRECORDENTRY = "Sales book contains duplicate "
            + "salesRecordEntry(s).";
    private final List<JsonAdaptedSalesRecordEntry> salesRecordEntries = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableSalesBook} with the given salesRecordEntries.
     */
    @JsonCreator
    public JsonSerializableSalesBook(
            @JsonProperty("salesRecordEntries") List<JsonAdaptedSalesRecordEntry> salesRecordEntries) {
        this.salesRecordEntries.addAll(salesRecordEntries);
    }

    /**
     * Converts a given {@code ReadOnlySalesBook} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableSalesBook}.
     */
    public JsonSerializableSalesBook(ReadOnlySalesBook source) {
        salesRecordEntries.addAll(source.getSalesRecord().stream().map(JsonAdaptedSalesRecordEntry::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this sales book into the model's {@code SalesBook} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public SalesBook toModelType() throws IllegalValueException {
        SalesBook salesBook = new SalesBook();
        for (JsonAdaptedSalesRecordEntry jsonAdaptedSalesRecordEntry : salesRecordEntries) {
            SalesRecordEntry salesRecordEntry = jsonAdaptedSalesRecordEntry.toModelType();
            if (salesBook.hasSalesRecordEntry(salesRecordEntry)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_SALESRECORDENTRY);
            }
            salesBook.addSalesRecordEntry(salesRecordEntry);
        }
        return salesBook;
    }

}
