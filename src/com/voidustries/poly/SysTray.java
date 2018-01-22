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

        Image image = Toolkit.getDefaultToolkit().getImage("src/com/voidustries/poly/assets/icon.png");

        PopupMenu trayPopupMenu = new PopupMenu();

        MenuItem action = new MenuItem("Open Poly");
        action.addActionListener(e -> PolyThreads.startThread(2));
        trayPopupMenu.add(action);

        MenuItem close = new MenuItem("Close");
        close.addActionListener(e -> System.exit(1));
        trayPopupMenu.add(close);

        TrayIcon trayIcon = new TrayIcon(image, "SystemTray Demo", trayPopupMenu);

        trayIcon.setImageAutoSize(true);

        try{
            systemTray.add(trayIcon);
        }catch(AWTException awtException){
            awtException.printStackTrace();
        }
    }
}
