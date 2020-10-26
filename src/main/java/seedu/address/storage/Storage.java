package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyIngredientBook;
import seedu.address.model.ReadOnlySalesBook;
import seedu.address.model.ReadOnlySalesTimeBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;

/**
 * API of the Storage component
 */
public interface Storage extends AddressBookStorage, IngredientBookStorage, SalesBookStorage,
        SalesTimeBookStorage, UserPrefsStorage {


    @Override
    Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException;

    @Override
    void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;

    @Override
    Path getAddressBookFilePath();

    @Override
    Optional<ReadOnlyAddressBook> readAddressBook() throws DataConversionException, IOException;

    @Override
    void saveAddressBook(ReadOnlyAddressBook addressBook) throws IOException;

    @Override
    Path getSalesBookFilePath();

    @Override
    Path getSalesTimeBookFilePath();

    @Override
    Optional<ReadOnlySalesBook> readSalesBook() throws DataConversionException, IOException;

    @Override
    void saveSalesBook(ReadOnlySalesBook salesBook) throws IOException;

    @Override
    void saveSalesTimeBook(ReadOnlySalesTimeBook salesTimeBook) throws IOException;

    @Override
    Optional<ReadOnlySalesTimeBook> readSalesTimeBook() throws DataConversionException, IOException;

    @Override
    Path getIngredientBookFilePath();

    @Override
    Optional<ReadOnlyIngredientBook> readIngredientBook() throws DataConversionException, IOException;

    @Override
    void saveIngredientBook(ReadOnlyIngredientBook ingredientBook) throws IOException;

}
