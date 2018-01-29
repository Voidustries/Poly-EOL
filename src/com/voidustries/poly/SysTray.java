package com.voidustries.poly;

import java.awt.*;
import java.util.logging.Logger;

public class SysTray {

    private static final Logger LOGGER = Logger.getLogger( System.class.getName() );

    public static void systray() {

        if(!SystemTray.isSupported()){
            System.out.println("System tray is not supported !!! ");
            return ;
        }

        SystemTray systemTray = SystemTray.getSystemTray();

        Image image = Toolkit.getDefaultToolkit().getImage("src/com/voidustries/poly/assets/Icon.png");

        PopupMenu trayPopupMenu = new PopupMenu();

        MenuItem action = new MenuItem("Open Poly");
        action.addActionListener(e -> PolyThreads.startThread(2));
        trayPopupMenu.add(action);

        MenuItem close = new MenuItem("Close");
        close.addActionListener(e -> PolyThreads.startShutdown());
        trayPopupMenu.add(close);

        TrayIcon trayIcon = new TrayIcon(image, "Poly", trayPopupMenu);

        trayIcon.setImageAutoSize(true);

        try{
            systemTray.add(trayIcon);
        }catch(AWTException awtException){
            awtException.printStackTrace();
        }
    }
}
