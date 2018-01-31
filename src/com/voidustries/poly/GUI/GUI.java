package com.voidustries.poly.GUI;

// Class Created by Stone Monarch on 1/20/2018

import com.voidustries.poly.Main;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GUI extends Application {
    private static Stage mainStage;


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("layoutForm.fxml"));

        Platform.setImplicitExit(false);

        Scene scene = new Scene(root, 450, 450);

        Image applicationIcon = new Image(getClass().getResourceAsStream("assets/icon.png"));
        primaryStage.getIcons().add(applicationIcon);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Poly");
        primaryStage.setScene(scene);
        primaryStage.show();
        mainStage = primaryStage;
    }

    private static void show() {
        Platform.runLater(() -> mainStage.show());
    }

    public static void LaunchGUI() {
        Main.LOGGER.info("Launching GUI");
        try {
            launch();
        } catch (IllegalStateException e) {
            show();
        }
    }
}
