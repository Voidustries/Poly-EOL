package com.voidustries.poly;

/*
Class Created by Stone Monarch on 1/30/2018

Creator Comments:

        Keeps track of all running threads and can be called to shutdown all at once being sure
        not to exit in the middle of a process.
*/

import com.voidustries.poly.gui.GUI;

class PolyThreads {

    static void startThread(int threadNum) {

        switch (threadNum) {
            case 1:
                Main.LOGGER.entering("SysTray", "Starting Systray...");
                Thread sysTrayTh = new Thread(SysTray::launchSysTray);
                sysTrayTh.start();
                break;

            case 2:
                Main.LOGGER.entering("GUI", "Starting GUI...");
                Thread guiTh = new Thread(GUI::launchGUI);
                guiTh.start();
                break;

            default:
                Main.LOGGER.severe("StartThread failed.");
                break;
        }
    }

    static void startShutdown() {
        Main.LOGGER.exiting("PolyThreads", "Shutting down...");
        System.out.println("Shutting down....");
        System.exit(1);
    }
}
