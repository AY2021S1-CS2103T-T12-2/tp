package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyIngredientBook;
/**
 * Represents a storage for {@link seedu.address.model.IngredientBook}.
 */
public interface IngredientBookStorage {

    /**
     * Returns the file path of the data file.
     */
    Path getIngredientBookFilePath();

    /**
     * Returns AddressBook data as a {@link ReadOnlyIngredientBook}.
     *   Returns {@code Optional.empty()} if storage file is not found.
     * @throws DataConversionException if the data in storage is not in the expected format.
     * @throws IOException if there was any problem when reading from the storage.
     */
    Optional<ReadOnlyIngredientBook> readIngredientBook() throws DataConversionException, IOException;

    /**
     * @see #getIngredientBookFilePath()
     */
    Optional<ReadOnlyIngredientBook> readIngredientBook(Path filePath) throws DataConversionException, IOException;

    /**
     * Saves the given {@link ReadOnlyIngredientBook} to the storage.
     * @param addressBook cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveIngredientBook(ReadOnlyIngredientBook addressBook) throws IOException;

    /**
     * @see #saveIngredientBook(ReadOnlyIngredientBook)
     */
    void saveIngredientBook(ReadOnlyIngredientBook addressBook, Path filePath) throws IOException;

}

