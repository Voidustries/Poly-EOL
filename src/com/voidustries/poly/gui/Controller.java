package com.voidustries.poly.gui;

/*
Class Created by Stone Monarch on 1/20/2018

Creator Comments:

        All functionality for the main GUI
*/

import com.voidustries.poly.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
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
    private Spinner<Integer> rss_update;
    @FXML
    private Spinner<Integer> download_update;
    @FXML
    private Spinner<Integer> f2_after;

    @FXML
    private void onApply(MouseEvent mouseEvent) {
        Main.LOGGER.info("Apply Clicked");
        saveSettings();
    }

    @FXML
    private void onCancel(MouseEvent mouseEvent) {
        Main.LOGGER.info("Cancel Clicked");
        resetSettings();
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
        } catch (NullPointerException e) {
            Main.LOGGER.warning("No Folder Chosen: " + e);
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
        } catch (NullPointerException e) {
            Main.LOGGER.warning("No Folder Chosen: " + e);
        }
    }

    @FXML
    private void setF2(MouseEvent mouseEvent) {
        Main.LOGGER.entering("FilterGUI", "Starting Filter GUI...");

        // TODO: Make Filter Setup GUI
    }

    private void saveSettings() {
        try {
            Properties saveProps = new Properties();
            saveProps.setProperty("rss_url", rss_url.getText());
            saveProps.setProperty("database_dir", database_dir.getText());
            saveProps.setProperty("show_dir", show_dir.getText());
            saveProps.setProperty("rss_update", rss_update.getValue().toString());
            saveProps.setProperty("download_update", download_update.getValue().toString());
            saveProps.setProperty("f2", f2_after.getValue().toString());
            saveProps.store(new FileOutputStream("settings.properties"), "");
        } catch (IOException e) {
            Main.LOGGER.warning("CANNOT SAVE TO FILE " + e);
        }
    }

    private void resetSettings() {
        try {
            Properties resetProps = new Properties();
            resetProps.load(new FileInputStream("settings.properties"));
            rss_url.setText(resetProps.getProperty("rss_url"));
            database_dir.setText(resetProps.getProperty("database_dir"));
            show_dir.setText(resetProps.getProperty("show_dir"));
            rss_update.getValueFactory().setValue(Integer.parseInt(resetProps.getProperty("rss_update")));
            download_update.getValueFactory().setValue(Integer.parseInt(resetProps.getProperty("download_update")));
            f2_after.getValueFactory().setValue(Integer.parseInt(resetProps.getProperty("f2")));
        } catch (IOException e) {
            Main.LOGGER.config("Reset failed: " + e);
        }
    }

    public void checkRSSURL(MouseEvent mouseEvent) {
        Main.LOGGER.info("Checking URL...");
    }
}
