package com.projet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DBConnection {
    Connection connection;
    String databaseName= "bd_projet_agl";
    private String url = "jdbc:mysql://localhost/"+databaseName+"?characterEncoding=utf8&useConfigs=maxPerformance";


    private String username = "root";

    private String password = "";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url, username, password);
            JOptionPane.showMessageDialog(null, "Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
