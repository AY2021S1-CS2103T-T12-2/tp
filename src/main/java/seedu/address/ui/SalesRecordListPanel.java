package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.SalesRecordEntry;

/**
 * A ui for the SalesBook that is displayed in the body of the application.
 */
public class SalesRecordListPanel extends UiPart<Region> {

    private static final String FXML = "SalesRecordListPanel.fxml";

    private final Logger logger = LogsCenter.getLogger(SalesRecordListPanel.class);

    @FXML
    private Label header;
    @FXML
    private ListView<SalesRecordEntry> salesRecordEntryListView;

    /**
     * Creates a {@code SalesRecordListPanel} with the given {@code ObservableList}.
     */
    public SalesRecordListPanel(ObservableList<SalesRecordEntry> salesRecordEntries) {
        super(FXML);
        header.setText("Sales Tracker");
        salesRecordEntryListView.setItems(salesRecordEntries);
        salesRecordEntryListView.setCellFactory(listView -> new SalesRecordListViewCell());
        logger.fine("SalesRecordListPanel was successfully set up.");
    }

    /**
     * Custom {@code ListCell} that displays the details of a {@code SalesRecordEntry} using a
     * {@code SalesRecordEntryCard}.
     */
    class SalesRecordListViewCell extends ListCell<SalesRecordEntry> {
        @Override
        protected void updateItem(SalesRecordEntry entry, boolean empty) {
            super.updateItem(entry, empty);

            if (empty || entry == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new SalesRecordEntryCard(entry).getRoot());
            }
        }
    }
}
