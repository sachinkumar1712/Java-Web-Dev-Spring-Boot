package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main{
    public static void main(String[] args){
        try{
            Connection  connection =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/product_db",
                            "root", "12345678"
                    );
            System.out.println("Connected to database successfully");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }


    }
}