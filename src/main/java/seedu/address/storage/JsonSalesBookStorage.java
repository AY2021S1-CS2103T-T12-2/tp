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
import seedu.address.model.ReadOnlySalesBook;


/**
 * A class to access SalesBook data stored as a json file on the hard disk.
 */
public class JsonSalesBookStorage implements SalesBookStorage {

    private static final Logger logger = LogsCenter.getLogger(JsonSalesBookStorage.class);

    private Path filePath;

    public JsonSalesBookStorage(Path filePath) {
        this.filePath = filePath;
    }

    public Path getSalesBookFilePath() {
        return filePath;
    }

    @Override
    public Optional<ReadOnlySalesBook> readSalesBook() throws DataConversionException {
        return readSalesBook(filePath);
    }

    /**
     * Similar to {@link #readSalesBook()}.
     *
     * @param filePath location of the data. Cannot be null.
     * @throws DataConversionException if the file is not in the correct format.
     */
    public Optional<ReadOnlySalesBook> readSalesBook(Path filePath) throws DataConversionException {
        requireNonNull(filePath);

        Optional<JsonSerializableSalesBook> jsonSalesBook = JsonUtil.readJsonFile(
                filePath, JsonSerializableSalesBook.class);
        if (!jsonSalesBook.isPresent()) {
            return Optional.empty();
        }

        try {
            return Optional.of(jsonSalesBook.get().toModelType());
        } catch (IllegalValueException ive) {
            logger.info("Illegal values found in " + filePath + ": " + ive.getMessage());
            throw new DataConversionException(ive);
        }
    }

    @Override
    public void saveSalesBook(ReadOnlySalesBook salesBook) throws IOException {
        saveSalesBook(salesBook, filePath);
    }

    /**
     * Similar to {@link #saveSalesBook(ReadOnlySalesBook)}.
     *
     * @param filePath location of the data. Cannot be null.
     */
    public void saveSalesBook(ReadOnlySalesBook salesBook, Path filePath) throws IOException {
        requireNonNull(salesBook);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        JsonUtil.saveJsonFile(new JsonSerializableSalesBook(salesBook), filePath);
    }

}
