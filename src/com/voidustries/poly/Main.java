package com.voidustries.poly;

// Class Created by Stone Monarch on 1/20/2018

import java.util.logging.*;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    static {
        LOGGER.setLevel(Level.FINE);
    }

    public static void main(String[] args) {
        // TODO Make a Splash

        // Try to start the System Tray

        SysTray.systray();
    }
}
