/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achs.DAO;

import com.achs.DTO.LoginDTO;
import com.achs.connectionManager.ConnectionManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author avinash
 */
public class LoginDAO {
    public boolean validateUser(LoginDTO loginDTO) throws SQLException{
    
        PreparedStatement pst = ConnectionManager.getConnection()
                .prepareStatement("SELECT * FROM Login WHERE username=? AND password=?");
        pst.setString(1, loginDTO.getUserName());
        pst.setString(2, loginDTO.getPassword());
        
        ResultSet rs = pst.executeQuery();
        
        if(rs.next()){
            return true;
        }else{
            return false;
        }
    }
}
