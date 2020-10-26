package seedu.address.storage;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.FileUtil;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.ReadOnlySalesTimeBook;

public class JsonSalesTimeBookStorage implements SalesTimeBookStorage {
    private static final Logger logger = LogsCenter.getLogger(JsonSalesTimeBookStorage.class);

    private Path filePath;

    public JsonSalesTimeBookStorage(Path filePath) {
        this.filePath = filePath;
    }

    public Path getSalesTimeBookFilePath() {
        return filePath;
    }

    @Override
    public Optional<ReadOnlySalesTimeBook> readSalesTimeBook() throws DataConversionException {
        return readSalesTimeBook(filePath);
    }

    /**
     * Similar to {@link #readSalesTimeBook()}.
     *
     * @param filePath location of the data. Cannot be null.
     * @throws DataConversionException if the file is not in the correct format.
     */
    public Optional<ReadOnlySalesTimeBook> readSalesTimeBook(Path filePath) throws DataConversionException {
        requireNonNull(filePath);

        Optional<JsonSerializableSalesTimeBook> jsonSalesTimeBook = JsonUtil.readJsonFile(
            filePath, JsonSerializableSalesTimeBook.class);
        if (!jsonSalesTimeBook.isPresent()) {
            return Optional.empty();
        }

        try {
            return Optional.of(jsonSalesTimeBook.get().toModelType());
        } catch (IllegalValueException ive) {
            logger.info("Illegal values found in " + filePath + ": " + ive.getMessage());
            throw new DataConversionException(ive);
        }
    }

    @Override
    public void saveSalesTimeBook(ReadOnlySalesTimeBook salesTimeBook) throws IOException {
        saveSalesTimeBook(salesTimeBook, filePath);
    }

    /**
     * Similar to {@link #saveSalesTimeBook(ReadOnlySalesTimeBook)}.
     *
     * @param filePath location of the data. Cannot be null.
     */
    public void saveSalesTimeBook(ReadOnlySalesTimeBook salesTimeBook, Path filePath) throws IOException {
        requireNonNull(salesTimeBook);
        requireNonNull(filePath);
        FileUtil.createIfMissing(filePath);
        JsonUtil.saveJsonFile(new JsonSerializableSalesTimeBook(salesTimeBook), filePath);
    }
}
