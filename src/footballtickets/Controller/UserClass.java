/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballtickets.Controller;

/**
 *      Contains all the details for the user so that it can be stored and passed around the program
 * @author D_Shipley
 */
public class UserClass {
    
    private String username;
    private String firstName;
    private String lastName;
    private String membership;
    
    public UserClass(String _username, String _firstName, String _lastName, String _membership){
        this.username = _username;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.membership = _membership;
    }
       
    public String getUserName(){
        return username;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getMembership(){
        return membership;
    }
}
