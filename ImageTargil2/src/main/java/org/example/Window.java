package org.example;

import javax.swing.*;

public class Window extends JFrame {






    public Window(){
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.add(new Panel(0,0,500,500));
        this.setVisible(true);
    }

}
