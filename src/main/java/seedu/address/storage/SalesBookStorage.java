package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlySalesBook;


/**
 * Represents a storage for {@link seedu.address.model.SalesBook}.
 */
public interface SalesBookStorage {

    /**
     * Returns the file path of the data file.
     */
    Path getSalesBookFilePath();

    /**
     * Returns SalesBook data as a {@link ReadOnlySalesBook}.
     *   Returns {@code Optional.empty()} if storage file is not found.
     * @throws DataConversionException if the data in storage is not in the expected format.
     * @throws IOException if there was any problem when reading from the storage.
     */
    Optional<ReadOnlySalesBook> readSalesBook() throws DataConversionException, IOException;

    /**
     * @see #getSalesBookFilePath()
     */
    Optional<ReadOnlySalesBook> readSalesBook(Path filePath) throws DataConversionException, IOException;

    /**
     * Saves the given {@link ReadOnlySalesBook} to the storage.
     * @param salesBook cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveSalesBook(ReadOnlySalesBook salesBook) throws IOException;

    /**
     * @see #saveSalesBook(ReadOnlySalesBook)
     */
    void saveSalesBook(ReadOnlySalesBook salesBook, Path filePath) throws IOException;

}
