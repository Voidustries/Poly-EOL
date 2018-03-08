package com.voidustries.poly;

// Class Created by Stone Monarch on 1/20/2018

import java.io.IOException;
import java.util.logging.*;

public class Main {

    public final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        try {
            setupLogger();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PolySplash.splash();

        // Try to start the System Tray
        PolyThreads.startThread(1);
    }

    private static void setupLogger() throws IOException {
        ConsoleHandler CONSOLE_HANDLER = new ConsoleHandler();
        FileHandler FILE_HANDLER = new FileHandler("PolyLogFile.log");
        Formatter FORMATTER = new CustomFormatter();
        LOGGER.addHandler(CONSOLE_HANDLER);
        CONSOLE_HANDLER.setLevel(Level.ALL);
        FILE_HANDLER.setLevel(Level.ALL);
        LOGGER.addHandler(FILE_HANDLER);
        FILE_HANDLER.setFormatter(FORMATTER);
        LOGGER.setLevel(Level.ALL);
        LOGGER.setUseParentHandlers(false);
    }

    public static boolean isThisWorking(boolean arg) {
        return arg;
    }
}
