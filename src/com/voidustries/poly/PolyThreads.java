package com.voidustries.poly;

import com.voidustries.poly.GUI.GUI;

public class PolyThreads {

    public static void startThread(int threadNum) {

        switch (threadNum) {
            case 1: Thread sysTrayTh = new Thread(SysTray::systray);
                    sysTrayTh.start();
                    Main.logging(1, "System Tray Starting...");
                    break;

            case 2: Thread guiTh = new Thread(GUI::LaunchGUI);
                    guiTh.start();
                    break;
        }
    }

    public static void startShutdown() {
        System.out.println("Shutting down....");
        System.exit(1);
    }
}
