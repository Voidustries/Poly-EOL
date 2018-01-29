package com.voidustries.poly;

// Class Created by Stone Monarch on 1/20/2018

import java.util.logging.*;

public class Main {

    private static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        LOGGER.setLevel(Level.FINE);

        LOGGER.fine("Logger started");
        // TODO Make a Splash

        // Try to start the System Tray

        PolyThreads.startThread(1);
    }
}
