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
import seedu.address.model.ReadOnlyIngredientBook;

/**
 * A class to access IngredientBook data stored as a json file on the hard disk.
 */
public class JsonIngredientBookStorage implements IngredientBookStorage {

    private static final Logger logger = LogsCenter.getLogger(JsonIngredientBookStorage.class);

    private Path filePath;

    public JsonIngredientBookStorage(Path filePath) {
        this.filePath = filePath;
    }

    public Path getIngredientBookFilePath() {
        return filePath;
    }

    @Override
    public Optional<ReadOnlyIngredientBook> readIngredientBook() throws DataConversionException {
        return readIngredientBook(filePath);
    }

    /**
     * Similar to {@link #readIngredientBook()}.
     *
     * @param filePath location of the data. Cannot be null.
     * @throws DataConversionException if the file is not in the correct format.
     */
    public Optional<ReadOnlyIngredientBook> readIngredientBook(Path filePath) throws DataConversionException {
        requireNonNull(filePath);

        Optional<JsonSerializableIngredientBook> jsonIngredientBook = JsonUtil.readJsonFile(
                filePath, JsonSerializableIngredientBook.class);
        if (!jsonIngredientBook.isPresent()) {
            return Optional.empty();
        }

        try {
            return Optional.of(jsonIngredientBook.get().toModelType());
        } catch (IllegalValueException ive) {
            logger.info("Illegal values found in " + filePath + ": " + ive.getMessage());
            throw new DataConversionException(ive);
        }
    }

    @Override
    public void saveIngredientBook(ReadOnlyIngredientBook ingredientBook) throws IOException {
        saveIngredientBook(ingredientBook, filePath);
    }

    /**
     * Similar to {@link #saveIngredientBook(ReadOnlyIngredientBook)}.
     *
     * @param filePath location of the data. Cannot be null.
     */
    public void saveIngredientBook(ReadOnlyIngredientBook ingredientBook, Path filePath) throws IOException {
        requireNonNull(ingredientBook);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        JsonUtil.saveJsonFile(new JsonSerializableIngredientBook(ingredientBook), filePath);
    }

}
