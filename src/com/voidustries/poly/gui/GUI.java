package com.voidustries.poly.gui;

/*
Class Created by Stone Monarch on 1/20/2018

Creator Comments:

        Launches the main settings GUI and loads the previous settings, OR Runs first time setup if needed
*/

import com.voidustries.poly.Main;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class GUI extends Application {

    private static Stage mainStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        String settings = "settings.properties";
        File f = new File(settings);

        if (!f.exists()) {
            makeDefaults();
        }
        FXMLLoader loader = new FXMLLoader();
        FileInputStream fis = new FileInputStream(settings);
        ResourceBundle resourceBundle = new PropertyResourceBundle(fis);
        loader.setResources(resourceBundle);

        Parent root = loader.load(getClass().getResourceAsStream("layoutForm.fxml"));

        Platform.setImplicitExit(false);

        Scene scene = new Scene(root/*, 472, 450*/);

        Image applicationIcon = new Image(getClass().getResourceAsStream("icon.png"));
        primaryStage.getIcons().add(applicationIcon);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Poly");
        primaryStage.setScene(scene);
        primaryStage.show();
        mainStage = primaryStage;

    }

    public static void LaunchGUI() {
        Main.LOGGER.info("Launching GUI");
        try {
            launch();
        } catch (IllegalStateException e) {
            Platform.runLater(() -> mainStage.show());
        }
    }

    public static Stage getMainStage() {
        return mainStage;
    }

    private static void makeDefaults() {
        try {
            Properties makeDefaultProps = new Properties();
            makeDefaultProps.setProperty("rss_url", "");
            makeDefaultProps.setProperty("database_dir", "");
            makeDefaultProps.setProperty("show_dir", "");
            makeDefaultProps.setProperty("rss_update", "1");
            makeDefaultProps.setProperty("download_update", "1");
            makeDefaultProps.setProperty("f2", "48");
            makeDefaultProps.setProperty("shows_left", "");
            makeDefaultProps.setProperty("number_in_database", "");
            makeDefaultProps.store(new FileOutputStream("settings.properties"), "");
        } catch (IOException e) {
            Main.LOGGER.warning("CANNOT CREATE DEFAULT SETTINGS FILE: " + e);
        }
    }
}
