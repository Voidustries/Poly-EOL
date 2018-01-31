package com.voidustries.poly;

// Class Created by Stone Monarch on 1/20/2018

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());
    private final static ConsoleHandler CONSOLE_HANDLER = new ConsoleHandler();

    public static void main(String[] args) {

        LOGGER.setLevel(Level.FINE);
        CONSOLE_HANDLER.setLevel(Level.FINE);
        LOGGER.addHandler(CONSOLE_HANDLER);
        LOGGER.log(Level.FINE, "My log");


        // TODO Make a Splash

        // Try to start the System Tray

        PolyThreads.startThread(1);
    }

    public static void logging (int level, String message) {

        switch (level) {
            case 1:
                LOGGER.log(Level.FINE, message);
                break;

            case 2:
                LOGGER.log(Level.FINE, message);
                break;

            case 3:
                LOGGER.log(Level.FINE, message);
                break;

            case 4:
                LOGGER.log(Level.FINE, message);
                break;

            case 5:
                LOGGER.log(Level.FINE, message);
                break;

            default:
                LOGGER.log(Level.SEVERE, "UNKNOWN LOGGING LEVEL");
                break;
        }
    }
}
