/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballtickets;
import footballtickets.View.*;
//import footballtickets.Model.*;
//import footballtickets.Controller.*;
/**
 *
 * @author D_Shi
 */
public class FootballTickets {
    
    public void closeProgram(){
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FrmUserLogIn userLogIn = new FrmUserLogIn();
        userLogIn.setVisible(true);        
    }
    
}
