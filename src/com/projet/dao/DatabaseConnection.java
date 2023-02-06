package com.projet.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;



public class DatabaseConnection {
	public Connection databaseLink;

	public Connection getConnection() {
		
		String databaseName= "bd_projet_agl";
		String databaseUser = "root";
		String databasePassword = "";
		String url = "jdbc:mysql://localhost/"+databaseName+"?characterEncoding=utf8&useConfigs=maxPerformance";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
			JOptionPane.showMessageDialog(null, "Connected");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return databaseLink;
		
	}

}
