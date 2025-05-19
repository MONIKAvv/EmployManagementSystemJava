package Employ.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back;
    Login(){
//        text and image ko jFrame main use karna
        JLabel username = new JLabel("Username");
        username.setBounds(40, 20, 100, 50);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150, 20, 250, 30);
        add(tusername);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        getColorModel();
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150, 70, 250,30);
        add(tpassword);

        login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        back = new JButton("BACK");
        back.setBounds(350, 140, 150,30);
        back.addActionListener(this);
        add(back);

//        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/front1.gif"));
//        Image i22 = i11.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
//        ImageIcon i33 = new ImageIcon(i22);
//        JLabel img = new JLabel(i33);
//        img.setBounds(0, 0 , 600, 600);
//        add(img);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imgbg = new JLabel(i3);
        imgbg.setBounds(200, 0 , 600, 300);
        add(imgbg);


        setSize(600, 300);
        setLocation(450, 200);
        setLayout(null);
        setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){

        } else if (e.getSource() == back) {
            System.exit(30);

        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
