package com.voidustries.poly.GUI;

// Class Created by Stone Monarch on 1/20/2018

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.logging.Logger;

public class GUI extends Application {

    private static final Logger LOGGER = Logger.getLogger( GUI.class.getName() );

    @Override
    public void start (Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Platform.setImplicitExit(false);

        Scene scene = new Scene(root,450,450);

        Image applicationIcon = new Image(getClass().getResourceAsStream("assets/icon.png"));
        primaryStage.getIcons().add(applicationIcon);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Poly");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void gui () {
        launch();
    }
}
