/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ACER
 */
public class Proyecto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Connection connection = null; 
        String host="localhost";
        String port="5432";
        String db_name="db_institucion";
        String username="postgres";
        String password="jeremias12345";
        try {
           Class.forName("org.postgresql.Driver");
           connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password+"");
        if (connection != null) {
            //System.out.println("Connection ok"); 
            Statement stmt = connection.createStatement();
            ResultSet rs;
            connection.close();
        }
         else {
                //System.out.println("Connection Failed");
             } 
        } catch (Exception e) {
            e.printStackTrace();
        
        }
    }
}     
