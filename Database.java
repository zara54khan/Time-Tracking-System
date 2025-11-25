package com.timetrack;

import java.sql.*;

public class Database {

    private static Connection conn;

    public static Connection getConnection() {
        try {
            if(conn == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/time_tracking",
                        "root",
                        "YOUR_PASSWORD");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
