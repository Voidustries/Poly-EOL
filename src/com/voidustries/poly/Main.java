package com.voidustries.poly;

// Class Created by Stone Monarch on 1/20/2018

import com.voidustries.poly.GUI.GUI;

import java.util.logging.*;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    static {
        LOGGER.setLevel(Level.FINE);
    }

    public static void main(String[] args) {

        while (true) {
            GUI.gui();
        }
    }

}
