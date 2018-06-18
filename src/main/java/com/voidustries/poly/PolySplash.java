package com.voidustries.poly;
/*
Class Created by Stone Monarch on 3/1/2018

Creator Comments:

        
*/

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.concurrent.TimeUnit;

class PolySplash {

    static void splash() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        URL url = PolySplash.class.getResource("splash.gif");
        JWindow window = new JWindow();

        try {
            window.getContentPane().add(new JLabel("", new ImageIcon(url), SwingConstants.CENTER));
            window.setBounds((screenWidth / 2) - 241, (screenHeight / 2) - 330, 482, 661);
            window.setVisible(true);
            TimeUnit.SECONDS.sleep(7);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            window.setVisible(false);
            window.dispose();
        }
    }

}
