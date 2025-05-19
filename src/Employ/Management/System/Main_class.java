package Employ.Management.System;

import javax.swing.*;

public class Main_class extends JFrame {
    Main_class(){
        JLabel name = new JLabel("whatsup !");
        add(name);



        setSize(500, 500);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Main_class();
    }
}
