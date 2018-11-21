/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achs.connectionManager;

/**
 *
 * @author avinash
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/studentlogin","root","");
            return connection;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    
}
