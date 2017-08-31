package com.krasutski;

import com.krasutski.view.MainController;
import com.krasutski.language.Messages;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Locale;

public class MainApp extends Application {

    private static final String FXML_RESOURCE_NAME = "/fxml/main.fxml";
    private static final String CSS_RESOURCE_NAME = "/styles/styles.css";

    public static void main(String[] args) throws Exception {
        // Forced to set the language
        //Locale.setDefault(new Locale("en", "EN"));
        //Locale.setDefault(new Locale("be", "BY"));
        //Locale.setDefault(new Locale("ru", "RU"));

        launch(args);
    }

    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setResources(Messages.GetBundle());
        Parent rootNode = loader.load(getClass().getResourceAsStream(FXML_RESOURCE_NAME));

        Scene scene = new Scene(rootNode, 640, 480);
        scene.getStylesheets().add(CSS_RESOURCE_NAME);

        stage.setTitle(Messages.MAIN_APP_TITLE);
        stage.setMinHeight(480);
        stage.setMinWidth(640);

        final ObservableList<Image> icons = stage.getIcons();
        icons.add(new Image("/icons/app-128x128x32.png"));

        stage.setScene(scene);

        MainController controller = loader.getController();
        controller.setStage(stage);

        stage.show();
    }
}
