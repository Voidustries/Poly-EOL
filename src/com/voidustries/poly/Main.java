package com.voidustries.poly;

// Class Created by Stone Monarch on 1/20/2018

import java.util.logging.*;

public class Main {

    public final static Logger LOGGER = Logger.getLogger(Main.class.getName());
    private final static ConsoleHandler CONSOLE_HANDLER = new ConsoleHandler();

    public static void main(String[] args) {

        LOGGER.setLevel(Level.ALL);
        CONSOLE_HANDLER.setLevel(Level.ALL);
        LOGGER.addHandler(CONSOLE_HANDLER);

        // TODO Make a Splash

        // Try to start the System Tray
        PolyThreads.startThread(1);
    }
}
