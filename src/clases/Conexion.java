/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.*;

/**
 *
 * @author Victor
 */
public class Conexion {
    
    // conexion local 
    
    public static Connection Conectar(){
        
    String URL = "jdbc:mysql://localhost:3306/bd_ds?zeroDateTimeBehavior=convertToNull";
    String USER = "root";
    String PASS = "";
    
        try{
            
            Connection cn = DriverManager.getConnection(URL, USER ,PASS);
            System.err.println("Conexion Correcta");
            return cn;
            
        }catch(SQLException e){
            System.out.println(e);
            
        }
        return null;
    }


    
    
}
