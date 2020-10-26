package seedu.address.model.ingredient;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.model.ingredient.exceptions.NoChangeIngredientException;

class UniqueIngredientListTest {

    private static final UniqueIngredientList uniqueIngredientList = new UniqueIngredientList();
    private static final UniqueIngredientList myIngredientList = new UniqueIngredientList();
    private static final Ingredient BLACK_TEA = new Ingredient(new IngredientName("Black Tea"));
    private static final Ingredient BLACK_TEA_VALID_AMOUNT = new Ingredient(new IngredientName("Black Tea"),
            new Amount("90"));
    private static final Ingredient BOBA = new Ingredient(new IngredientName("Boba"));
    private static final List<Ingredient> internalList = new ArrayList<>();


    @Test
    public void contains_nullIngredient_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueIngredientList.contains(null));
    }

    /*@Test
    public void contains_ingredientInList_returnsTrue() {
        assertTrue(uniqueIngredientList.contains(OOLONG_TEA));
    }*/

    @Test
    public void setIngredient_nullTargetIngredient_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueIngredientList.setIngredient(null,
                BLACK_TEA_VALID_AMOUNT));
    }

    @Test
    public void setIngredient_nullEditedIngredient_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueIngredientList.setIngredient(BLACK_TEA,
                null));
    }

    @Test
    public void setIngredient_targetIngredientNotInList_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> uniqueIngredientList
                .setIngredient(new Ingredient(new IngredientName("Olong Tea")), BLACK_TEA_VALID_AMOUNT));
    }

    /*@Test
    public void setIngredient_editedIngredientIsSameIngredient_throwsNoChangeIngredientException() {

        assertThrows(NoChangeIngredientException.class, ()
            -> uniqueIngredientList.setIngredient(OOLONG_TEA, OOLONG_TEA));
    }*/

    /*@Test
    public void setIngredient_editedIngredientHasDifferentAmount_success() {
        System.out.println(uniqueIngredientList);
        myIngredientList.setIngredient(OOLONG_TEA, OOLONG_TEA_VALID_AMOUNT);

        UniqueIngredientList expectedUniqueIngredientList = new UniqueIngredientList();
        expectedUniqueIngredientList.setIngredient(OOLONG_TEA, OOLONG_TEA_VALID_AMOUNT);
        assertEquals(expectedUniqueIngredientList, myIngredientList);
    }*/

    /*@Test
    public void setIngredient_editedIngredientHasNoChange_throwsNoChangeIngredientException() {
        assertThrows(NoChangeIngredientException.class, () -> uniqueIngredientList.setIngredient(OOLONG_TEA,
                BOBA));
    }*/

    @Test
    public void setIngredients_nullUniqueIngredientList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueIngredientList.setIngredients(
                (UniqueIngredientList) null));
    }

    @Test
    public void setIngredients_uniqueIngredientList_replacesOwnListWithProvidedUniqueIngredientList() {
        UniqueIngredientList expectedUniqueIngredientList = new UniqueIngredientList();

        uniqueIngredientList.setIngredients(expectedUniqueIngredientList);
        assertEquals(expectedUniqueIngredientList, uniqueIngredientList);
    }

    @Test
    public void setIngredients_nullList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueIngredientList.setIngredients(
                (List<Ingredient>) null));
    }

    /*@Test
    public void setIngredients_list_replacesOwnListWithProvidedList() {
        internalList.add(new Ingredient(new IngredientName("Milk")));
        internalList.add(new Ingredient(new IngredientName("Pearl")));
        internalList.add(new Ingredient(new IngredientName("Boba")));
        internalList.add(new Ingredient(new IngredientName("Oolong Tea"), new Amount("90")));
        internalList.add(new Ingredient(new IngredientName("Brown Sugar")));
        uniqueIngredientList.setIngredients(internalList);
        UniqueIngredientList expectedUniqueIngredientList = new UniqueIngredientList();
        expectedUniqueIngredientList.setIngredient(OOLONG_TEA, OOLONG_TEA_VALID_AMOUNT);
        assertEquals(expectedUniqueIngredientList, uniqueIngredientList);
    }*/

    @Test
    public void setIngredients_listWithDuplicateIngredients_throwsNoChangeIngredientException() {
        List<Ingredient> listWithDuplicateIngredients = Arrays.asList(BLACK_TEA, BLACK_TEA);
        assertThrows(NoChangeIngredientException.class, ()
            -> uniqueIngredientList.setIngredients(listWithDuplicateIngredients));
    }

    @Test
    public void asUnmodifiableObservableList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, ()
            -> uniqueIngredientList.asUnmodifiableObservableList().remove(0));
    }

}
