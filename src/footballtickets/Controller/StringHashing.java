/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballtickets.Controller;

import java.io.*;
import java.security.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author D_Shi
 */
public class StringHashing {
    
    public String Sha1(String input){           
        String sha1 = null;
        
        try {

            MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");

            msdDigest.update(input.getBytes("UTF-8"), 0, input.length());

            sha1 = DatatypeConverter.printHexBinary(msdDigest.digest());

        } 
        catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {

          Logger.getLogger(StringHashing.class.getName()).log(Level.SEVERE, null, e);
        }
        
        //System.out.println(input);
        //System.out.println(sha1);
       return sha1;
    }
}
