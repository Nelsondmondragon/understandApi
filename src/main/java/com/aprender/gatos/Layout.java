package com.aprender.gatos;

import javax.swing.*;
import java.awt.*;

public class Layout extends JFrame {
    private ImageIcon ima[];

    public Layout(ImageIcon ima[]) {
        this.ima = ima;
        this.setSize(600, 500);
        this.setVisible(true);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int x=0;
        for (int i = 0; i < ima.length; i++) {
            if(i>0){
                x+=ima[i].getImage().getWidth(this);
            }
            g.drawImage(ima[i].getImage(), x, 0, 100, 100, null);

        }
    }
}
