package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.Drink;
import seedu.address.model.IngredientBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyIngredientBook;
import seedu.address.model.ReadOnlySalesBook;
import seedu.address.model.SalesBook;
import seedu.address.model.SalesRecordEntry;
import seedu.address.model.ingredient.Amount;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.IngredientName;
import seedu.address.model.person.Address;
import seedu.address.model.person.ArchiveStatus;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"),
                new Phone("90993478"),
                new Address("Blk 30 Geylang Street 29, #06-40"),
                new ArchiveStatus(false),
                getTagSet("Friday", "Thursday", "PartTime")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"),
                new Phone("85727299"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                new ArchiveStatus(false),
                getTagSet("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "FullTime")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"),
                new Phone("98201239"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                new ArchiveStatus(false),
                getTagSet("Saturday", "Sunday", "Friday", "PartTime")),
            new Person(new Name("David Li"), new Phone("91031282"),
                new Phone("88213019"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                new ArchiveStatus(false),
                getTagSet("Friday", "Thursday", "Monday", "Saturday", "Sunday", "FullTime")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"),
                new Phone("82029429"),
                new Address("Blk 47 Tampines Street 20, #17-35"),
                new ArchiveStatus(true),
                getTagSet("Wednesday", "Monday", "Friday", "Sunday", "PartTime")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"),
                new Phone("91442629"),
                new Address("Blk 45 Aljunied Street 85, #11-31"),
                new ArchiveStatus(true),
                getTagSet("Monday", "Tuesday", "Wednesday", "Thursday", "Saturday", "FullTime"))
        };
    }

    public static SalesRecordEntry[] getSampleSales() {
        return new SalesRecordEntry[]{
            new SalesRecordEntry(Drink.BSBM, 0),
            new SalesRecordEntry(Drink.BSBBT, 0),
            new SalesRecordEntry(Drink.BSBGT, 0),
            new SalesRecordEntry(Drink.BSPM, 0),
            new SalesRecordEntry(Drink.BSPBT, 0),
            new SalesRecordEntry(Drink.BSPGT, 0)
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }


    public static ReadOnlySalesBook getSampleSalesBook() {
        SalesBook sampleSb = new SalesBook();
        for (SalesRecordEntry sampleSalesRecordEntry : getSampleSales()) {
            sampleSb.addSalesRecordEntry(sampleSalesRecordEntry);
        }
        return sampleSb;
    }

    public static Ingredient[] getSampleIngredients() {
        return new Ingredient[]{
            new Ingredient(new IngredientName("Milk"), new Amount("0")),
            new Ingredient(new IngredientName("Pearl"), new Amount("0")),
            new Ingredient(new IngredientName("Boba"), new Amount("0")),
            new Ingredient(new IngredientName("Black Tea"), new Amount("0")),
            new Ingredient(new IngredientName("Green Tea"), new Amount("0")),
            new Ingredient(new IngredientName("Brown Sugar"), new Amount("0"))
        };
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    public static ReadOnlyIngredientBook getSampleIngredientBook() {
        IngredientBook sampleIb = new IngredientBook();
        for (Ingredient sampleIngredient : getSampleIngredients()) {
            sampleIb.addIngredient(sampleIngredient);
        }
        return sampleIb;
    }
}
