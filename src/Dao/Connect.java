/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author UKiel
 */
public class Connect {
    Connection conn = null;
    public Connect() {
    }
    
    public Connection getConnection() {
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://KIEI-DARENL:1433;databaseName=LMS_PROJECT2;user=sa;password=123456";
            conn = DriverManager.getConnection(url);

            return conn;
            
	} catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
	}
        return null;
    }

}