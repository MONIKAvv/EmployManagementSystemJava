package Employ.Management.System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmploy extends JFrame implements ActionListener {
    Random ran = new Random();
    int randomnumber = ran.nextInt(999999);
    JTextField tname, tfathername, taddress, tphone, taadhar, temail, tsalary, tdesignation;

    JLabel tempid;
    JDateChooser tdob;
    JComboBox boxeducation;

    JButton add, back;

    AddEmploy() {
        getContentPane().setBackground(new Color(156, 155, 188));
        JLabel heading = new JLabel("Add Employees Detail");
        heading.setBounds(320, 30, 400, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(250, 90, 150, 30);
        empid.setFont(new Font("SAN_SERIF", Font.ITALIC, 20));
        add(empid);

        tempid = new JLabel(""+randomnumber);
        tempid.setBounds(400, 90,150, 30);
        tempid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tempid.setForeground(new Color(200, 100, 100));
        add(tempid);


        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        tname = new JTextField();
        tname.setBounds(200, 150, 150, 30);
        tname.setBackground(new Color(157, 152, 177));
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);

        tfathername = new JTextField();
        tfathername.setBounds(600, 150, 200, 30);
        tfathername.setBackground(new Color(157, 152, 177));
        add(tfathername);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(200, 200, 150, 30);
        tdob.setBackground(new Color(177, 252, 197));
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        tsalary.setBackground(new Color(157, 152, 177));
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        taddress.setBackground(new Color(157, 152, 177));
        add(taddress);

        JLabel phoneno = new JLabel("Phone N0.");
        phoneno.setBounds(400, 250, 150, 30);
        phoneno.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phoneno);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        tphone.setBackground(new Color(157, 152, 177));
        add(tphone);

        JLabel aadhar = new JLabel("Aadhar No.");
        aadhar.setBounds(50, 300, 150, 30);
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(aadhar);

        taadhar = new JTextField();
        taadhar.setBounds(200, 300, 150, 30);
        taadhar.setBackground(new Color(157, 152, 177));
        add(taadhar);

        JLabel email = new JLabel("Email");
        email.setBounds(400, 300, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);

        temail = new JTextField();
        temail.setBounds(600, 300, 270, 30);
        temail.setBackground(new Color(157, 152, 177));
        add(temail);


        JLabel designation = new JLabel("Designation");
        designation.setBounds(40, 350, 150, 30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        tdesignation.setBackground(new Color(157, 152, 177));
        add(tdesignation);

        JLabel education = new JLabel("Highest Education");
        education.setBounds(400, 350, 150, 30);
        education.setFont(new Font("SAN_SARIF", Font.BOLD, 20));
        add(education);

        String items[] = {"BBA", "Btech", "BCA", "MCA", "BSC", "Mtech", "MBA", "Msc", "PHD", "BA", "B.COM", "MA"};
        boxeducation = new JComboBox(items);
        boxeducation.setBackground(new Color(157, 152, 177));
        boxeducation.setBounds(600, 350, 150, 30);
        add(boxeducation);


        add = new JButton("ADD");
        add.setBounds(690, 500, 150, 40);
        add.setBackground(Color.green);
        add.setForeground(Color.black);
        add(add);
        add.addActionListener(this);


        back = new JButton("BACK");
        back.setBounds(500, 500, 150, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);


        setSize(1000, 700);
        setLayout(null);
        setLocation(500, 50);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            String name = tname.getText();
            String fname = tfathername.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phoneno = tphone.getText();
            String email = temail.getText();
            String education = (String) boxeducation.getSelectedItem();
            String designation = tdesignation.getText();
            String empid = tempid.getText();
            String aadhar = taadhar.getText();


            try{
                connection c = new connection();
                String query = "insert into Employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phoneno+"', '"+email+"', '"+education+"', '"+aadhar+"','"+empid+"' ,'"+designation+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Added Successfully!");
                setVisible(false);
                new Main_class();

            }catch (Exception E){
                E.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new AddEmploy();
    }
}
