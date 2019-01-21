/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballtickets.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author D_Shi
 */
public class DBCreateNewUser {
    String username;
    String firstName;
    String lastName;
    String password;
    String usernameCheckSQL;
    String createUserSQL;
    PreparedStatement pstmt;
    ResultSet rS;
    int check;
    
    public DBCreateNewUser(String _username, String _firstName, String _lastName, String _password) throws SQLException{
        this.username = _username;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.password = _password;
    }
    
    public int CreateNewUser() throws SQLException{
        
        //Make the connection to the database
        Connection dbConnection = new DBConnection().ConnectToDB();
        
        //Code to actually add the user to the database
        //First check that there is not a user using that username and if there is ask for a different one
        usernameCheckSQL = "SELECT * FROM Users WHERE Username = ?";
        
        try{
            dbConnection.setAutoCommit(false);
            pstmt = dbConnection.prepareStatement(usernameCheckSQL);
            
            //Set the values to be used in the prepared statement
            pstmt.setString(1, username);
            
            //Execute the statement
            rS = pstmt.executeQuery();
            //Check to see if the username is free and create user if it is
            if (!rS.next()){
                System.out.println("Username Available");
                
                createUserSQL = "INSERT INTO Users (Username, First_Name, Surname, Password) VALUES (?, ?, ?, ?)";//Set up the prepared statement
                             
                try{
                    pstmt = dbConnection.prepareStatement(createUserSQL);

                    //Set the values to be used in the prepared statement
                    pstmt.setString(1, username);
                    pstmt.setString(2, firstName);
                    pstmt.setString(3, lastName);
                    pstmt.setString(4, password);

                    //Execute the statement
                    pstmt.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Welcome "+ firstName + ".", "New User Created", JOptionPane.INFORMATION_MESSAGE);
                    check = 1;
                }
                catch(Exception ex){
                    System.out.println(ex);
                }
                
                
            }else{
                JOptionPane.showMessageDialog(null, "Please select a different Username", "Username Taken", JOptionPane.ERROR_MESSAGE);
                check = 0;
            }
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
        //Close the Connection to the database
        dbConnection.close();
        System.out.println("Connection Closed");
        return check;
    }
    
}
