/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballtickets.Model;

import java.sql.*;
import footballtickets.Model.*;
import footballtickets.Controller.*;
import javax.swing.JOptionPane;

/**
 *
 * @author D_Shi
 */
public class DBLogIn{
    String username;
    String password;
    String firstName;
    String lastName;
    String membership;
    String loginSQL;
    String getUserSQL;
    PreparedStatement pstmt;
    ResultSet rS;
    int check;
    
    public DBLogIn(String _username, String _password){
        this.username = _username;
        this.password = _password;
    }
    
    public int logIn() throws SQLException{
        Connection dbConnection = new DBConnection().ConnectToDB();
        loginSQL = "SELECT * FROM Users WHERE Username = ? and Password = ?";
        
        try{
            dbConnection.setAutoCommit(false);
            pstmt = dbConnection.prepareStatement(loginSQL);
            
            //Set the values to be used in the prepared statement
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            //Execute the statement
            rS = pstmt.executeQuery();
            //Check to see if any results where found
            if (rS.next()){
                System.out.println("Log in successful");//Just here for work checking
                check = 1;
            }else{
                check = 0;
                JOptionPane.showMessageDialog(null, "Invalid Username and/or Password", "Access Denied", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        dbConnection.close();
        return check;
    }
    
    public UserClass setCurrentUser(String _username) throws SQLException{
        this.username =_username;
        Connection dbConnection = new DBConnection().ConnectToDB();
        getUserSQL = "SELECT * FROM Users WHERE Username = ?";
        
        dbConnection.setAutoCommit(false);
        pstmt = dbConnection.prepareStatement(getUserSQL);
            
        //Set the values to be used in the prepared statement
        pstmt.setString(1, username);
        rS = pstmt.executeQuery();
        
        while (rS.next()){
            firstName = rS.getString("First_Name");
            lastName = rS.getString("Surname");
            membership = rS.getString("Membership");
        }
        
        
        UserClass currentUser = new UserClass(username, firstName, lastName, membership);
        
        
        
        
        dbConnection.close();
        return currentUser;
    }
    
}
