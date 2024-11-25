package org.example.airlinesystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AirlineSystem {
    public static void main(String[] args) throws Exception {
        String sql = "select * from customers";
        String url = "jdbc:postgresql://localhost:5432/final_project";
        String username = "postgres";
        String password = "123";
        Connection con = DriverManager.getConnection(url, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        String name = rs.getString("first_name");
        System.out.println(name);
    }
}
