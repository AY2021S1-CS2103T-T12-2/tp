package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIngredients.MILK;
import static seedu.address.testutil.TypicalIngredients.PEARL;
import static seedu.address.testutil.TypicalIngredients.UPDATED_MILK;
import static seedu.address.testutil.TypicalIngredients.UPDATED_PEARL;
import static seedu.address.testutil.TypicalIngredients.getTypicalIngredientBook;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.IngredientBook;
import seedu.address.model.ReadOnlyIngredientBook;

public class JsonIngredientBookStorageTest {
    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data",
            "JsonIngredientBookStorageTest");

    @TempDir
    public Path testFolder;

    @Test
    public void readIngredientBook_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> readIngredientBook(null));
    }

    private java.util.Optional<ReadOnlyIngredientBook> readIngredientBook(String filePath) throws Exception {
        return new JsonIngredientBookStorage(Paths.get(filePath)).readIngredientBook(
                addToTestDataPathIfNotNull(filePath));
    }

    private Path addToTestDataPathIfNotNull(String prefsFileInTestDataFolder) {
        return prefsFileInTestDataFolder != null
                ? TEST_DATA_FOLDER.resolve(prefsFileInTestDataFolder)
                : null;
    }

    @Test
    public void read_missingFile_emptyResult() throws Exception {
        assertFalse(readIngredientBook("NonExistentFile.json").isPresent());
    }

    @Test
    public void read_notJsonFormat_exceptionThrown() {
        assertThrows(DataConversionException.class, () -> readIngredientBook(
                "notJsonFormatIngredientBook.json"));
    }

    @Test
    public void readAndSaveIngredientBook_allInOrder_success() throws Exception {
        Path filePath = testFolder.resolve("TempIngredientBook.json");
        IngredientBook original = getTypicalIngredientBook();
        JsonIngredientBookStorage jsonIngredientBookStorage = new JsonIngredientBookStorage(filePath);

        // Save in new file and read back
        jsonIngredientBookStorage.saveIngredientBook(original, filePath);
        ReadOnlyIngredientBook readBack = jsonIngredientBookStorage.readIngredientBook(filePath).get();
        assertEquals(original, new IngredientBook(readBack));

        // Modify data, overwrite exiting file, and read back
        original.setIngredient(MILK, UPDATED_MILK);
        jsonIngredientBookStorage.saveIngredientBook(original, filePath);
        readBack = jsonIngredientBookStorage.readIngredientBook(filePath).get();
        assertEquals(original, new IngredientBook(readBack));

        // Save and read without specifying file path
        original.setIngredient(PEARL, UPDATED_PEARL);
        jsonIngredientBookStorage.saveIngredientBook(original); // file path not specified
        readBack = jsonIngredientBookStorage.readIngredientBook().get(); // file path not specified
        assertEquals(original, new IngredientBook(readBack));

    }


    @Test
    public void saveIngredientBook_nullAIngredientBook_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> saveIngredientBook(null, "SomeFile.json"));
    }

    private void saveIngredientBook(ReadOnlyIngredientBook ingredientBook, String filePath) {
        try {
            new JsonIngredientBookStorage(Paths.get(filePath))
                    .saveIngredientBook(ingredientBook, addToTestDataPathIfNotNull(filePath));
        } catch (IOException ioe) {
            throw new AssertionError("There should not be an error writing to the file.", ioe);
        }
    }

    @Test
    public void saveIngredientBook_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> saveIngredientBook(new IngredientBook(), null));
    }

}
