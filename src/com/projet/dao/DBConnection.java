package com.projet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static Connection connection;
    static String databaseName= "bd_projet_agl";
    private static String url = "jdbc:mysql://localhost/"+databaseName+"?characterEncoding=utf8&useConfigs=maxPerformance";


    private static String username = "root";

    private static String password = "";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
			try {
				connection = DriverManager.getConnection(url, username, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//JOptionPane.showMessageDialog(null, "Connected");
        return connection;
    }

}
