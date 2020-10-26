package seedu.address.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Represents a SalesBookEntry in the sales book.
 */
public class SalesBookEntry {

    private final LocalDate localDate;
    private final UniqueSalesRecordList salesRecordList;

    /**
     * Creates a SalesBookEntry which records the salesrecordlist of a date
     * @param localDate the time
     * @param salesRecordList the record of all drinks which have been sold
     */
    public SalesBookEntry(LocalDate localDate, UniqueSalesRecordList salesRecordList) {
        this.localDate = localDate;
        this.salesRecordList = salesRecordList;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public UniqueSalesRecordList getSalesRecordList() {
        return salesRecordList;
    }

    /**
     * A record entry is the same as another record entry if they record the same date.
     *
     * @param otherEntry the other record entry to compare to
     * @return true if they record the same Drink item, and false otherwise
     */
    public boolean isSameSalesRecordList(SalesBookEntry otherEntry) {
        if (otherEntry == this) {
            return true;
        }

        return this.localDate.equals(otherEntry.localDate);
    }

    @Override
    public String toString() {
        StringBuilder display = new StringBuilder();
        salesRecordList.forEach(x -> display.append(x + "\n"));
        return localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "\n" + display.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof SalesBookEntry)) {
            return false;
        }

        SalesBookEntry otherEntry = (SalesBookEntry) other;
        return otherEntry.localDate.equals(localDate)
                && otherEntry.salesRecordList == salesRecordList;
    }

    @Override
    public int hashCode() {
        return Objects.hash(localDate, salesRecordList);
    }
}
