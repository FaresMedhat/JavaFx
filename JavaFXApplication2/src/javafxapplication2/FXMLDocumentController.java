package javafxapplication2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLDocumentController {

    private String currentUnit; // Holds the selected unit

    @FXML
    private TextField amount; // Matches fx:id in FXML

    @FXML
    private Button meterButton, cmButton, gramButton, kgButton; // Buttons referenced in FXML

    @FXML
    private Label label; // Label for displaying the result

    /**
     * Handles the selection of the current unit (cm or g).
     */
    @FXML
    private void handleSelectionCurrentUnit(ActionEvent event) {
        if (event.getSource() == cmButton) {
            currentUnit = "cm";
            label.setText("Current unit set to cm.");
        } else if (event.getSource() == gramButton) {
            currentUnit = "g";
            label.setText("Current unit set to g.");
        }
    }

    /**
     * Converts the value in the text field to meters if the current unit is cm.
     */
    @FXML
    private void handleConvertToMeter(ActionEvent event) {
        try {
            if ("cm".equals(currentUnit)) {
                double value = Double.parseDouble(amount.getText());
                double convertedValue = value / 100; // Convert cm to meters
                label.setText(String.format("%.2f meters", convertedValue));
            } else {
                label.setText("Unit must be 'cm' to convert to meters.");
            }
        } catch (NumberFormatException e) {
            label.setText("Invalid input! Please enter a number.");
        }
    }

    /**
     * Converts the value in the text field to kilograms if the current unit is g.
     */
    @FXML
    private void handleConvertToKG(ActionEvent event) {
        try {
            if ("g".equals(currentUnit)) {
                double value = Double.parseDouble(amount.getText());
                double convertedValue = value / 1000; // Convert grams to kilograms
                label.setText(String.format("%.2f kg", convertedValue));
            } else {
                label.setText("Unit must be 'g' to convert to kg.");
            }
        } catch (NumberFormatException e) {
            label.setText("Invalid input! Please enter a number.");
        }
    }
}
