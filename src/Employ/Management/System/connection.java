package Employ.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connection {

    Connection javaconnection ;
    Statement statement;

    public connection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            javaconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employmanagement","root","Monik@Root12345");
            statement = javaconnection.createStatement();


        }catch (Exception e ){
            e.printStackTrace();
        }
    }


}
