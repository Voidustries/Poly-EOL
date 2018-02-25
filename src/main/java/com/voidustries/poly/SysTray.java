package com.voidustries.poly;

/*
Class Created by Stone Monarch on 1/30/2018

Creator Comments:

        Creates a basic SystemTray to show that Poly is running and allows the GUI
        tobe launched at anytime, while also allowing the Shutdown to be called at
        anytime.
*/

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class SysTray {

    public static void systray() {

        if (!SystemTray.isSupported()) {
            Main.LOGGER.warning("SysTray not supported!");
            return;
        }

        SystemTray systemTray = SystemTray.getSystemTray();

        URL url = SysTray.class.getResource("/Icon.png");
        Image image = new ImageIcon(url).getImage();

        PopupMenu trayPopupMenu = new PopupMenu();

        MenuItem action = new MenuItem("Open Poly");
        action.addActionListener(e -> PolyThreads.startThread(2));
        trayPopupMenu.add(action);

        MenuItem close = new MenuItem("Close");
        close.addActionListener(e -> PolyThreads.startShutdown());
        trayPopupMenu.add(close);

        TrayIcon trayIcon = new TrayIcon(image, "Poly", trayPopupMenu);
        trayIcon.setImageAutoSize(true);

        try {
            systemTray.add(trayIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
