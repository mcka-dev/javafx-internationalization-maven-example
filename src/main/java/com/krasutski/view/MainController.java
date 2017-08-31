package com.krasutski.view;

import com.krasutski.language.Messages;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class MainController implements Initializable {

    @FXML
    public Button clickMeButton;

    @FXML
    public TextArea outputTextArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        print(Messages.MAIN_CONTROLLER_HELLO_TEXT);
    }

    private void print(String text) {
        outputTextArea.appendText(text + System.lineSeparator());
        System.out.println(text);
    }

    private Optional<ButtonType> showAlert(final Alert.AlertType alertType, final String message) {
        Alert alert = new Alert(alertType);
        alert.setHeaderText(Messages.DIALOG_HEADER);
        alert.setContentText(message);
        return alert.showAndWait();
    }

    public void setStage(Stage stage) {
        // Hot key Ctrl + H for clickMe button
        stage.addEventFilter(KeyEvent.KEY_PRESSED, (event -> {
            if (new KeyCodeCombination(KeyCode.H, KeyCombination.CONTROL_DOWN).match(event)) {
                clickMeAction();
                event.consume();
            }
        }));

        // Stage is closing
        stage.setOnCloseRequest(e -> {
            try {
                print(Messages.MAIN_CONTROLLER_GOODBYE_TEXT);
            } catch (Throwable t) {
                t.printStackTrace();
                System.exit(-1);
            }
        });
    }

    public void clickMeAction() {
        Optional<ButtonType> result = showAlert(Alert.AlertType.CONFIRMATION, Messages.MAIN_CONTROLLER_CONTENT_TEXT);
        result.ifPresent(buttonType ->print(buttonType.getText()));
    }
}
