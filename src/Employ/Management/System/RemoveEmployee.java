package Employ.Management.System;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {

    Choice choiceEmpID;
    JButton delete, back;
    String empnum;
    RemoveEmployee(String empnum){
        this.empnum = empnum;

        JLabel label = new JLabel("Employee ID");
        label.setBounds(50, 50, 100, 30);
        label.setFont(new Font("tahoma", Font.BOLD, 15));
        add(label);

        choiceEmpID = new Choice();
        choiceEmpID.setBounds(200, 50, 150, 30);
        add(choiceEmpID);

        try{
            connection c= new connection();
            ResultSet resultSet = c.statement.executeQuery("select * from Employee");
            while (resultSet.next()){
                choiceEmpID.add(resultSet.getString("empid"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        JLabel labelName = new JLabel("Name");
        labelName.setBounds(50, 100,100,30);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelName);

        JLabel textName = new JLabel();
        textName.setBounds(200, 100,100,30);
        add(textName);

        JLabel labelEmail = new JLabel("Email");
        labelEmail.setBounds(50, 150,100,30);
        labelEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelEmail);

        JLabel textEmail = new JLabel();
        textEmail.setBounds(200, 200,100,30);
        add(textEmail);

        JLabel labelPhoneno = new JLabel("Phone");
        labelPhoneno.setBounds(50, 200,100,30);
        labelPhoneno.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelPhoneno);

        JLabel textPhoneno = new JLabel();
        textPhoneno.setBounds(200, 150,100,30);
        add(textPhoneno);

        try{
            connection c = new connection();
            ResultSet resultSet = c.statement.executeQuery("select * from Employee where empid = '"+choiceEmpID.getSelectedItem()+"'");
            while (resultSet.next()){
                textName.setText(resultSet.getString("name"));
                textPhoneno.setText(resultSet.getString("phoneno"));
                textEmail.setText(resultSet.getString("email"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }

        choiceEmpID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    connection c = new connection();
                    ResultSet resultSet = c.statement.executeQuery("select * from Employee where empid = '"+choiceEmpID.getSelectedItem()+"'");
                    while (resultSet.next()){
                        textName.setText(resultSet.getString("name"));
                        textPhoneno.setText(resultSet.getString("phoneno"));
                        textEmail.setText(resultSet.getString("email"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        delete = new JButton("DELETE");
        delete.setBounds(800, 300, 100,30);
        delete.setBackground(Color.RED);
        delete.setForeground(Color.black);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("BACK");
        back.setBounds(650, 300, 100,30);
        back.setBackground(Color.CYAN);
        back.setForeground(Color.black);
        back.addActionListener(this);
        add(back);

//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
//        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel img = new JLabel(i3);
//        img.setBounds(700, 80, 200, 200);
//        add(img);
//
//        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/deletebg.jpg"));
//        Image i22 = i11.getImage().getScaledInstance(1170, 630, Image.SCALE_DEFAULT);
//        ImageIcon i33 = new ImageIcon(i22);
//        JLabel image = new JLabel(i33);
//        image.setBounds(0, 0, 1170, 630);
//        add(image);


        setSize(1000,400);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == delete){
            try{
                connection c = new connection();
                String query = "delete from Employee where empid = '"+choiceEmpID.getSelectedItem()+"'";
                choiceEmpID.remove(choiceEmpID.getSelectedItem());
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Deleted Successfully!");
                setVisible(false);
                new Main_class();
            }catch (Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee("");
    }
}
