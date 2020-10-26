package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.ReadOnlySalesTimeBook;
import seedu.address.model.SalesBookEntry;
import seedu.address.model.SalesTimeBook;

/**
 * An Immutable SalesTimeBook that is serializable to JSON format.
 */
@JsonRootName(value = "salestimebook")
class JsonSerializableSalesTimeBook {
    public static final String MESSAGE_DUPLICATE_SALESRECORDENTRY = "SalesTimeBook list contains duplicate "
            + "salesBookEntry(s).";
    private final List<JsonAdaptedSalesBookEntry> salesBookEntries = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableSalesTimeBook} with the given salesBookEntries.
     */
    @JsonCreator
    public JsonSerializableSalesTimeBook(
        @JsonProperty("salesBookEntries") List<JsonAdaptedSalesBookEntry> salesBookEntries) {
        this.salesBookEntries.addAll(salesBookEntries);
    }

    /**
     * Converts a given {@code ReadOnlySalesTimeBook} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableSalesTimeBook}.
     */
    public JsonSerializableSalesTimeBook(ReadOnlySalesTimeBook source) {
        salesBookEntries.addAll(source.getSalesBookList().stream().map(JsonAdaptedSalesBookEntry::new)
            .collect(Collectors.toList()));
    }

    /**
     * Converts this sales time book into the model's {@code SalesTimeBook} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public SalesTimeBook toModelType() throws IllegalValueException {
        SalesTimeBook salesTimeBook = new SalesTimeBook();
        for (JsonAdaptedSalesBookEntry jsonAdaptedSalesBookEntry : salesBookEntries) {
            SalesBookEntry salesBookEntry = jsonAdaptedSalesBookEntry.toModelType();
            if (salesTimeBook.hasSalesBookEntry(salesBookEntry)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_SALESRECORDENTRY);
            }
            salesTimeBook.addSalesBookEntry(salesBookEntry);
        }
        return salesTimeBook;
    }
}
