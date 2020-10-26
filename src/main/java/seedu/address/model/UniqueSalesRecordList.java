package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.sales.exception.DuplicateSalesRecordException;
import seedu.address.model.sales.exception.SalesRecordNotFoundException;

/**
 * A list of sales records that enforces uniqueness between its elements and does not allow nulls.
 * A sales record is considered unique by comparing using {@code SalesRecordEntry#isSameRecord(SalesEntryRecord)}. As
 * such, adding and updating of a sales record entry uses {@code SalesRecordEntry#isSameRecord(SalesEntryRecord)} for
 * equality so as to ensure that the sales record entry being added or updated is unique in terms of identity in the
 * UniqueSalesRecordList. However, the removal of a sales record entry uses SalesRecordEntry#equals(Object) so
 * as to ensure that the sales record entry with exactly the same fields will be removed.
 *
 * Supports a minimal set of list operations.
 */
public class UniqueSalesRecordList implements Iterable<SalesRecordEntry> {

    private final ObservableList<SalesRecordEntry> internalList = FXCollections.observableArrayList();
    private final ObservableList<SalesRecordEntry> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);


    /**
     * Returns true if the list contains an equivalent record entry of {@Code SalesRecordEntry toCheck}.
     *
     * @param toCheck the sales record entry to check for
     * @return true if the list contains an equivalent record entry
     */
    public boolean contains(SalesRecordEntry toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameRecord);
    }

    /**
     * Adds the given {@SalesRecordEntry toAdd} to the list.
     * If there exists a record of the same drink in the list, that record will be replaced.
     *
     * @param toAdd the SalesRecordEntry to be added
     */
    public void add(SalesRecordEntry toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            // if it exists, then replace it with the new entry
            setSalesEntry(toAdd);
        }
        internalList.add(toAdd);
    }

    /**
     * Sets and replaces the entry that is recording the same Drink item as {@Code newEntry}.
     *
     * @param newEntry the sales record entry to be updated.
     */
    public void setSalesEntry(SalesRecordEntry newEntry) {
        requireNonNull(newEntry);
        // find the sales entry with the drink
        int index = indexOf(newEntry.getDrink());
        if (index == -1) {
            throw new SalesRecordNotFoundException();
        }

        assert index > -1;

        internalList.set(index, newEntry); // replace with the new entry
    }

    public SalesRecordEntry getSalesEntry(Drink drink) {
        int index = indexOf(drink);
        if (index == -1) {
            throw new SalesRecordNotFoundException();
        }

        assert index > -1;

        return internalList.get(index);
    }

    /**
     * Returns the index of the sales record which stores the {@Code Drink drink}.
     * Otherwise, returns -1 if the {@Code drink} cannot be found.
     *
     * @param drink the drink item to search for in the record
     * @return the index of the record entry that stores the drink
     */
    private int indexOf(Drink drink) {
        requireNonNull(drink);
        for (int i = 0; i < internalList.size(); i++) {
            if (internalList.get(i).getDrink().equals(drink)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Removes the equivalent sales record entry from the list.
     * The entry must already exist in the list.
     *
     * @param toRemove the sales record entry to be removed
     */
    public void remove(SalesRecordEntry toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new SalesRecordNotFoundException();
        }
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
    public void setSalesRecord(UniqueSalesRecordList replacement) {
        requireNonNull(replacement);
        internalList.setAll(replacement.internalList);
    }

    /**
     * Replaces the content of the list with the {@Code sales} as a List.
     *
     * @param sales a List containing sales record entries
     */
    public void setSalesRecord(List<SalesRecordEntry> sales) {
        requireAllNonNull(sales);
        if (!salesRecordEntriesAreUnique(sales)) {
            throw new DuplicateSalesRecordException();
        }

        internalList.setAll(sales);
    }

    /**
     * Replaces the content of the list with the {@Code sales} as a Map.
     *
     * @param sales a Map containing sales information of drinks sold
     */
    public void setSalesRecord(Map<Drink, Integer> sales) {
        requireNonNull(sales);
        ArrayList<SalesRecordEntry> newRecord = new ArrayList<>();
        sales.forEach((k, v) -> newRecord.add(new SalesRecordEntry(k, v)));
        internalList.setAll(newRecord);
    }

    /**
     * Returns true if {@code sales} contains only unique sales record entries.
     */
    private boolean salesRecordEntriesAreUnique(List<SalesRecordEntry> sales) {
        for (int i = 0; i < sales.size() - 1; i++) {
            for (int j = i + 1; j < sales.size(); j++) {
                if (sales.get(i).isSameRecord(sales.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<SalesRecordEntry> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    /**
     * Returns an iterator over elements of type {@code SalesRecordEntry}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<SalesRecordEntry> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniqueSalesRecordList // instanceof handles nulls
                && internalList.equals(((UniqueSalesRecordList) other).internalList));
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

}
