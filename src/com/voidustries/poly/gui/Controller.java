package com.voidustries.poly.gui;

/*
Class Created by Stone Monarch on 1/20/2018

Creator Comments:

        All functionality for the main GUI
*/

import com.voidustries.poly.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;

import java.io.File;

public class Controller {

    @FXML
    private TextField show_dir;
    @FXML
    private TextField database_location;

    @FXML
    private void onApply(MouseEvent mouseEvent) {
        Main.LOGGER.info("Apply Clicked");
    }

    @FXML
    private void onCancel(MouseEvent mouseEvent) {
        Main.LOGGER.info("Cancel Clicked");
    }

    @FXML
    private void dbDirChooser(MouseEvent mouseEvent) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File file = directoryChooser.showDialog(GUI.getMainStage());
        String dir = file.getAbsolutePath();
        database_location.setText(dir);
        Main.LOGGER.info("Database DIR Set to '" + dir + "'");
    }

    @FXML
    private void showDirChooser(MouseEvent mouseEvent) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File file = directoryChooser.showDialog(GUI.getMainStage());
        String dir = file.getAbsolutePath();
        show_dir.setText(dir);
        Main.LOGGER.info("Show DIR Set to '" + dir + "'");
    }

    @FXML
    private void setupSecondFilter(MouseEvent mouseEvent) {
        Main.LOGGER.entering("FilterGUI", "Starting Filter GUI...");

        // TODO: Make Filter Setup GUI
    }
}
