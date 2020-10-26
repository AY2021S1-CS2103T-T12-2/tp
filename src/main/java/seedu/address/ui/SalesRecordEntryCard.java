package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.model.SalesRecordEntry;

/**
 * An UI component that displays information of a {@code SalesRecordEntry}.
 */
public class SalesRecordEntryCard extends UiPart<Region> {

    public static final String FXML = "SalesRecordListCard.fxml";

    public final SalesRecordEntry entry;

    @FXML
    private Label record;

    /**
     * Creates a {@code SalesRecordEntryCard} with the given {@code SalesRecordEntry}.
     */
    public SalesRecordEntryCard(SalesRecordEntry entry) {
        super(FXML);
        this.entry = entry;
        record.setText(entry.toString());
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof SalesRecordEntryCard)) {
            return false;
        }

        // state check
        SalesRecordEntryCard card = (SalesRecordEntryCard) other;
        return record.getText().equals(card.record.getText())
                && entry.equals(card.entry);
    }



}
