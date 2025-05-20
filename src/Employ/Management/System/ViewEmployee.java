package Employ.Management.System;

import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener {
JTable table;
JButton searchbtn,print, update, back;
    Choice chooseemp;
    ViewEmployee(){

        getContentPane().setBackground(new Color(10, 47, 107));
        JLabel seach = new JLabel("Seach by EmpID");
        seach.setBounds(20, 20,150,30);
        seach.setForeground(Color.white);
        add(seach);

        chooseemp = new Choice();
        chooseemp.setBounds(180, 20, 150, 20);
        add(chooseemp);

        try {
            connection c = new connection();
            ResultSet resultSet = c.statement.executeQuery("select * from Employee");
            while (resultSet.next()){
                chooseemp.add(resultSet.getString("empid"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }



        table  = new JTable();
        try {
            connection c = new connection();
            ResultSet resultset = c.statement.executeQuery("select * from Employee");
            table.setModel(DbUtils.resultSetToTableModel(resultset));
        }catch (Exception e){
            e.printStackTrace();
        }
        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100, 900,600);
        add(jp);

        searchbtn = new JButton("Search Employee");
        searchbtn.setBounds(20,70, 150,20);
        searchbtn.addActionListener(this);
        add(searchbtn);

        print = new JButton("Print");
        print.setBounds(220, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(320, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(420, 70, 80, 20);
        back.addActionListener(this);
        add(back);





       setSize(900, 700);
       setLayout(null);
       setLocation(300, 100);
       setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchbtn){
            String query = "select * from Employee where empid = '"+chooseemp.getSelectedItem()+"'";
            try {
                connection c = new connection();
                ResultSet resultset = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultset));

            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == update) {
            try {
                setVisible(false);
                new UpdateEmployees(chooseemp.getSelectedItem());
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
            new Main_class();
        }

    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}
