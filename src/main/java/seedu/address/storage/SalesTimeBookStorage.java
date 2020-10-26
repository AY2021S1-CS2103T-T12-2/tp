package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlySalesTimeBook;

public interface SalesTimeBookStorage {

    /**
     * Returns the file path of the data file.
     */
    Path getSalesTimeBookFilePath();

    /**
     * Returns SalesBook data as a {@link ReadOnlySalesTimeBook}.
     *   Returns {@code Optional.empty()} if storage file is not found.
     * @throws DataConversionException if the data in storage is not in the expected format.
     * @throws IOException if there was any problem when reading from the storage.
     */
    Optional<ReadOnlySalesTimeBook> readSalesTimeBook() throws DataConversionException, IOException;

    /**
     * @see #getSalesTimeBookFilePath()
     */
    Optional<ReadOnlySalesTimeBook> readSalesTimeBook(Path filePath) throws DataConversionException, IOException;

    /**
     * Saves the given {@link ReadOnlySalesTimeBook} to the storage.
     * @param salesTimeBook cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveSalesTimeBook(ReadOnlySalesTimeBook salesTimeBook) throws IOException;


    /**
     * @see #saveSalesTimeBook(ReadOnlySalesTimeBook)
     *
     */
    void saveSalesTimeBook(ReadOnlySalesTimeBook salesTimeBook, Path filePath) throws IOException;

}
