/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achs.interfaces;

import java.sql.ResultSet;

/**
 *
 * @author avinash
 */
public interface StudentListener {
    
    public void onStudentInserted(ResultSet resultSet);
    public void onStudentEdited(ResultSet resultSet);
    public void onStudentDeleted(ResultSet resultSet);
    public void error(String message);
}
