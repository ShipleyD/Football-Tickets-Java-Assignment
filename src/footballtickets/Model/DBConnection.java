/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballtickets.Model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author D_Shi
 */
public class DBConnection {
    
    Connection conn; // This Connection variable will hold the details of the database connection used throughout this program.
    String url;
    String mySQLUsername;
    String mySQLPassword;
    
    public Connection ConnectToDB(){
        conn = null;//Make sure the variable is empty
        
        url = "jdbc:mysql://localhost:3306/FootballTickets";//Set the url for the database connection
        mySQLUsername = "root";//set the username for the database connection
        mySQLPassword = "";//set the password for the database connection
        
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, mySQLUsername, mySQLPassword);
            System.out.println("Connection Made");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection Failled");
        }
        return conn;
    }
    
}
