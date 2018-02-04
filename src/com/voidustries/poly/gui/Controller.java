package com.voidustries.poly.gui;

/*
Class Created by Stone Monarch on 1/20/2018

Creator Comments:

        All functionality for the main GUI
*/

import com.voidustries.poly.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Controller {

    @FXML
    private TextField rss_url;
    @FXML
    private TextField database_dir;
    @FXML
    private TextField show_dir;
    @FXML
    private Spinner rss_update;
    @FXML
    private Spinner download_update;
    @FXML
    private Spinner f2_after;
    @FXML
    private TextArea logField;

    @FXML
    private void onApply(MouseEvent mouseEvent) {
        Main.LOGGER.info("Apply Clicked");
        try {
            Properties saveProps = new Properties();
            saveProps.setProperty("rss_url", rss_url.getText());
            saveProps.setProperty("database_dir", database_dir.getText());
            saveProps.setProperty("show_dir", show_dir.getText());
            saveProps.setProperty("rss_update", rss_update.getValue().toString());
            saveProps.setProperty("download_update", download_update.getValue().toString());
            saveProps.setProperty("f2", f2_after.getValue().toString());
            saveProps.storeToXML(new FileOutputStream("settings.xml"), "");
        } catch (IOException e) {
            Main.LOGGER.warning("CANNOT SAVE TO FILE " + e);
            logField.setText("WARNING: COULD NOT SAVE TO FILE");
            return;
        }
        logField.appendText("RSS URL: " + rss_url.getText() + "\n");
        logField.appendText("Update RSS every " + rss_update.getValue() + " hours" + "\n");
        logField.appendText("Try downloads every " + download_update.getValue() + " hours" + "\n");
        logField.appendText("Switch to second filter after " + f2_after.getValue() + " tries" + "\n");
    }

    @FXML
    private void onCancel(MouseEvent mouseEvent) {
        Main.LOGGER.info("Cancel Clicked");
        GUI.getMainStage().close();
    }

    @FXML
    private void dbDirChooser(MouseEvent mouseEvent) {
        File file;
        DirectoryChooser directoryChooser = new DirectoryChooser();
        try {
            file = directoryChooser.showDialog(GUI.getMainStage());
            String dir = file.getAbsolutePath();
            database_dir.setText(dir);
            Main.LOGGER.info("Database DIR Set to '" + dir + "'");
            logField.appendText("Database Directory: " + dir + "\n");
        } catch (NullPointerException e) {
            Main.LOGGER.warning("No Folder Chosen: " + e);
            logField.appendText("Database Location: No Folder Chosen(" + e + ")\n");
        }
    }

    @FXML
    private void showDirChooser(MouseEvent mouseEvent) {
        File file;
        DirectoryChooser directoryChooser = new DirectoryChooser();
        try {
            file = directoryChooser.showDialog(GUI.getMainStage());
            String dir = file.getAbsolutePath();
            show_dir.setText(dir);
            Main.LOGGER.info("Show DIR Set to '" + dir + "'");
            logField.appendText("Show Directory: " + dir + "\n");
        } catch (NullPointerException e) {
            Main.LOGGER.warning("No Folder Chosen: " + e);
            logField.appendText("Show Directory: No Folder Chosen(" + e + ")\n");
        }
    }

    @FXML
    private void setupSecondFilter(MouseEvent mouseEvent) {
        Main.LOGGER.entering("FilterGUI", "Starting Filter GUI...");

        // TODO: Make Filter Setup GUI
    }

    {
        Properties loadProps = new Properties();
        try {
            loadProps.loadFromXML(new FileInputStream("settings.xml"));

            rss_url.setText(loadProps.getProperty("rss_url"));
        } catch (IOException e) {
            Main.LOGGER.warning("CANNOT LOAD FILE " + e);
        }
    }
}
