/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achs.DAO;

import com.achs.DTO.StudentDTO;
import com.achs.connectionManager.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author avinash
 */
public class StudentDAO {
    
    
    public void addStudent(StudentDTO studentDTO){
        try{
            Connection con = ConnectionManager.getConnection();
            String qry = "INSERT INTO Student_Info(fName, mName, lName, class, section, gender ) VALUES(?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, studentDTO.getFirstName());
            pst.setString(2, studentDTO.getMiddleName());
            pst.setString(3, studentDTO.getLastName());
            pst.setString(4, studentDTO.getGrade());
            pst.setString(5, studentDTO.getSection());
            pst.setString(6, studentDTO.getGender());
            pst.execute();
            
            con.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public List<StudentDTO> getStudentList(){
        
        List<StudentDTO> studentList = new ArrayList<>();
        try{
            Connection con = ConnectionManager.getConnection();
            String qry = "select * from Student_Info";
            PreparedStatement pst = con.prepareStatement(qry);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
               StudentDTO studentDTO = new  StudentDTO();
               studentDTO.setFirstName(rs.getString("fName"));
               studentDTO.setMiddleName(rs.getString("mName"));
               studentDTO.setLastName(rs.getString("lName"));
               studentDTO.setGrade(rs.getString("class"));
               studentDTO.setSection(rs.getString("section"));
               studentDTO.setGender(rs.getString("gender"));
               studentDTO.setId(rs.getInt("student_id"));
               
               studentList.add(studentDTO);
            }
            
            return studentList;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public StudentDTO updateStudent(StudentDTO studentDTO,String value){
        
        try{
            Connection con = ConnectionManager.getConnection();
            String qry = "UPDATE Student_Info SET fName = ?, mName=?, lName=?, class=?, section=?, gender=? WHERE student_id ="+value;
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, studentDTO.getFirstName());
            pst.setString(2, studentDTO.getMiddleName());
            pst.setString(3, studentDTO.getLastName());
            pst.setString(4, studentDTO.getGrade());
            pst.setString(5, studentDTO.getSection());
            pst.setString(6, studentDTO.getGender());
            pst.setString(6, studentDTO.getGender());
            
            pst.executeUpdate();
            
          
            return studentDTO;
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
        }
    
    public void deleteStudent(int id){
        String qry = "DELETE FROM Student_Info WHERE student_id="+id;
    }
}