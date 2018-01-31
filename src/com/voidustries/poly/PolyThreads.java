package com.voidustries.poly;

import com.voidustries.poly.GUI.GUI;

public class PolyThreads {

    public static void startThread(int threadNum) {

        switch (threadNum) {
            case 1: Thread sysTrayTh = new Thread(SysTray::systray);
                    sysTrayTh.start();
                    Main.LOGGER.entering("SysTray","Starting Systray");
                    break;

            case 2: Thread guiTh = new Thread(GUI::LaunchGUI);
                    guiTh.start();
                    Main.LOGGER.entering("GUI","Starting GUI");
                    break;
        }
    }

    public static void startShutdown() {
        Main.LOGGER.exiting("PolyThreads","Starting Systray");
        System.out.println("Shutting down....");
        System.exit(1);
    }
}
