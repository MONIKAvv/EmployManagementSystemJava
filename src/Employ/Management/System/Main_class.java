package Employ.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame implements ActionListener {
    JButton add, remove, update, view;

    Main_class() {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1120, 630);
        add(img);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(380, 50, 400, 30);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        heading.setForeground(Color.white);
        img.add(heading);

        add = new JButton("Add Employee");
        add.setBounds(135, 190, 150, 40);
        add.setForeground(Color.white);
        add.setBackground(new Color(15, 47, 110));
        add.addActionListener(this);
        img.add(add);

        view = new JButton("View Employee");
        view.setBounds(800, 190, 150, 40);
        view.setForeground(Color.white);
        view.setBackground(new Color(15, 47, 110));
        view.addActionListener(this);
        img.add(view);

        remove = new JButton("Remove Employee");
        remove.setBounds(467, 400, 150, 40);
        remove.setBackground(Color.RED);
        remove.setForeground(Color.white);
        remove.addActionListener(this);
        img.add(remove);


        setSize(1120, 630);
        setLocation(250, 100);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            try {
                new AddEmploy();
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == remove) {
            try {
                setVisible(false);
                new RemoveEmployee();
            } catch (Exception E) {
                E.printStackTrace();
            }

        } else if (e.getSource() == view) {
            try {
                new ViewEmployee();
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new Main_class();
    }
}
