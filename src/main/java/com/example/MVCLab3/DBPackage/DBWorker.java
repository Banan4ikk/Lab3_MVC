package com.example.MVCLab3.DBPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {
    private final String URL = "jdbc:mysql://localhost:3306/userdb";
    private final String USERNAME =  "root";
    private final String PASSWORD = "admin";

    private Connection connection;
    public DBWorker() {
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            System.err.println("Can't connect to DataBase");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
