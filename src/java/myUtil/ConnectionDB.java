/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Farewell
 */

public class ConnectionDB {
    private static Connection connection=null;
    public static  Connection getConnectionDB(){
        if (connection != null)
            return connection;
        else {
            try {               
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/ehealth";
                String user = "root";
                String password = "";
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            } catch (SQLException ex) {
                System.out.println(ex);
            } 
            return connection;
        }
    }
}