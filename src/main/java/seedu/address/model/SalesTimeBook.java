package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import seedu.address.commons.core.LogsCenter;


public class SalesTimeBook implements ReadOnlySalesTimeBook {

    private UniqueSalesBookList salesBookList;

    private final Logger logger = LogsCenter.getLogger(SalesTimeBook.class);

    public SalesTimeBook() {
        salesBookList = new UniqueSalesBookList();
    }

    /**
     * Creates a SalesTimeBook using the record in {@code toBeCopied}.
     *
     * @param toBeCopied the SalesBook to be copied from
     */
    public SalesTimeBook(ReadOnlySalesTimeBook toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    /**
     * Resets the existing data of this {@code SalesBook} with {@code newData}.
     */
    public void resetData(ReadOnlySalesTimeBook newData) {
        requireNonNull(newData);
        setRecord(newData.getSalesBookList());
    }

    public void setRecord(List<SalesBookEntry> sales) {
        requireNonNull(sales);
        salesBookList.setSalesBook(sales);
    }

    /**
     * Sets the sales record to the sales information which is provided as a Map.
     * This is used only at initialisation of the sales record.
     *
     * @param sales sales information that has been parsed.
     */
    public void setRecord(Map<LocalDate, UniqueSalesRecordList> sales) {
        requireNonNull(sales);
        assert !sales.isEmpty();
        logger.fine("SalesTimeBook is being initialised with the first user input.");
        salesBookList.setSalesBook(sales);
        assert !sales.isEmpty();
    }


    /**
     * Adds a salesBookEntry to the salesbook list.
     */
    public void addSalesBookEntry(SalesBookEntry s) {
        salesBookList.add(s);
    }

    /**
     * Returns true if a salesBookEntry with the same identity as {@code salesBookEntry} exists in the record.
     */
    public boolean hasSalesBookEntry(SalesBookEntry salesBookEntry) {
        requireNonNull(salesBookEntry);
        return salesBookList.contains(salesBookEntry);
    }

    public UniqueSalesBookList getRecord() {
        return salesBookList;
    }

    /**
     * Overwrites existing sales record based on the sales information which is provided as a Map.
     * This is used after sales record has been initialised.
     *
     * @param sales sales information that has been parsed.
     */
    public void overwriteSalesBook(Map<LocalDate, UniqueSalesRecordList> sales) {
        requireNonNull(sales);
        assert !sales.isEmpty();
        logger.fine("SalesTimeBook is being overwritten with the new user input.");
        HashMap<LocalDate, UniqueSalesRecordList> newRecord = new HashMap<>();
        // for all the sales items in sales, overwrite them in record
        for (LocalDate key : sales.keySet()) {
            Optional<UniqueSalesRecordList> userInput = Optional.ofNullable(sales.get(key));
            Optional<UniqueSalesRecordList> changedValue = userInput.map(x -> x == null
                    ? salesBookList.getSalesBook(key).getSalesRecordList()
                    : sales.get(key));
            newRecord.put(key, changedValue.get());
        }
        salesBookList.setSalesBook(newRecord);
        assert !salesBookList.isEmpty();
    }

    /**
     * Checks whether the sales book list is empty.
     *
     * @return true if the sales record is empty, false otherwise.
     */
    public boolean isEmptySalesBookList() {
        return salesBookList.isEmpty();
    }

    /**
     * Returns an unmodifiable view of the list of salesbook with local date
     * This map will not contain any duplicate salesbook items.
     */
    @Override
    public ObservableList<SalesBookEntry> getSalesBookList() {
        return salesBookList.asUnmodifiableObservableList();
    }

    @Override
    public String toString() {
        StringBuilder display = new StringBuilder();

        salesBookList.forEach(x -> display.append(x + "\n"));

        return display.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof SalesTimeBook // instanceof handles nulls
            && salesBookList.equals(((SalesTimeBook) other).salesBookList));
    }
}
