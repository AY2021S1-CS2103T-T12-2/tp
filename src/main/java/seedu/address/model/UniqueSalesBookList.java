package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.sales.exception.DuplicateSalesBookException;
import seedu.address.model.sales.exception.SalesBookNotFoundException;

/**
 * A list of sales book records that enforces uniqueness between its elements and does not allow nulls.
 * A sales record is considered unique by comparing using {@code SalesBookEntry#isSameSalesBook(SalesBookEntry)}. As
 * such, adding and updating of a sales book entry uses {@code SalesBookEntry#isSameSalesBook(SalesBookEntry)} for
 * equality so as to ensure that the sales book entry being added or updated is unique in terms of identity in the
 * UniqueSalesBookList.
 *
 * Supports a minimal set of list operations.
 */
public class UniqueSalesBookList implements Iterable<SalesBookEntry> {
    private final ObservableList<SalesBookEntry> internalList = FXCollections.observableArrayList();
    private final ObservableList<SalesBookEntry> internalUnmodifiableList =
        FXCollections.unmodifiableObservableList(internalList);

    /**
     * Returns true if the list contains an equivalent record entry of {@Code SalesBookEntry toCheck}.
     *
     * @param toCheck the sales book entry to check for
     * @return true if the list contains an equivalent sales book entry
     */
    public boolean contains(SalesBookEntry toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameSalesRecordList);
    }

    /**
     * Adds the given {@SalesBookEntry toAdd} to the list.
     * If there exists a salesbook of the same date, that record will be replaced.
     *
     * @param toAdd the SalesBookEntry to be added
     */
    public void add(SalesBookEntry toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            // if it exists, then replace it with the new entry
            setSalesBookEntry(toAdd);
        }
        internalList.add(toAdd);
    }

    /**
     * Sets and replaces the entry that is recording the same date as {@Code newEntry}.
     *
     * @param newEntry the SalesBookEntry to be updated.
     */
    public void setSalesBookEntry(SalesBookEntry newEntry) {
        requireNonNull(newEntry);
        // find the sales entry with the drink
        int index = indexOf(newEntry.getLocalDate());
        if (index == -1) {
            throw new SalesBookNotFoundException();
        }

        assert index > -1;

        internalList.set(index, newEntry); // replace with the new entry
    }

    public SalesBookEntry getSalesBook(LocalDate localDate) {
        int index = indexOf(localDate);
        if (index == -1) {
            throw new SalesBookNotFoundException();
        }

        assert index >= 0;

        return internalList.get(index);
    }

    /**
     * Returns the index of the sales record which stores the {@Code Salesbook }.
     * Otherwise, returns -1 if the {@Code drink} cannot be found.
     *
     * @param localDate the drink item to search for in the record
     * @return the index of the sales book entry that stores the sales book
     */
    private int indexOf(LocalDate localDate) {
        requireNonNull(localDate);
        for (int i = 0; i < internalList.size(); i++) {
            if (internalList.get(i).getLocalDate().equals(localDate)) {
                return i;
            }
        }

        return -1;
    }

    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    public int size() {
        return internalList.size();
    }

    /**
     * Replaces the content of the list with a {@Code UniqueSalesRecordList replacement}.
     *
     * @param replacement the list to be replaced with
     */
    public void setSalesBook(UniqueSalesBookList replacement) {
        requireNonNull(replacement);
        internalList.setAll(replacement.internalList);
    }

    /**
     * Replaces the content of the list with the {@Code sales} as a List.
     *
     * @param sales a List containing sales record entries
     */
    public void setSalesBook(List<SalesBookEntry> sales) {
        requireAllNonNull(sales);
        if (!salesBookEntriesAreUnique(sales)) {
            throw new DuplicateSalesBookException();
        }

        internalList.setAll(sales);
    }

    /**
     * Replaces the content of the list with the {@Code sales} as a Map.
     *
     * @param sales a Map containing sales information of drinks sold
     */
    public void setSalesBook(Map<LocalDate, UniqueSalesRecordList> sales) {
        requireNonNull(sales);
        ArrayList<SalesBookEntry> newRecord = new ArrayList<>();
        sales.forEach((k, v) -> newRecord.add(new SalesBookEntry(k, v)));
        internalList.setAll(newRecord);
    }

    /**
     * Returns true if {@code sales} contains only unique sales book entries.
     */
    private boolean salesBookEntriesAreUnique(List<SalesBookEntry> sales) {
        for (int i = 0; i < sales.size() - 1; i++) {
            for (int j = i + 1; j < sales.size(); j++) {
                if (sales.get(i).isSameSalesRecordList(sales.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<SalesBookEntry> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    /**
     * Returns an iterator over elements of type {@code SalesBookEntry}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<SalesBookEntry> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof UniqueSalesBookList // instanceof handles nulls
                && internalList.equals(((UniqueSalesBookList) other).internalList));
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }
}
