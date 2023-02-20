/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import Model.Admin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author khoa1
 */
public class FunctionAdmin {
    
    public static Admin Login(String email, String password) {
            Admin admin = null;
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM ADMIN WHERE EMAIL = '" + email + "' AND PASS = '" + password + "'");
            while (rs.next()) {
                admin = new Admin();
                admin.setId(rs.getInt("ID"));
                admin.setName(rs.getString("NAME"));
                admin.setDob(rs.getDate("D_O_B"));
                admin.setGender(rs.getString("GENDER"));
                admin.setAddress(rs.getString("ADDRESS"));
                admin.setPhone(rs.getString("PHONE"));
                admin.setEmail(rs.getString("EMAIL"));
                admin.setPass(rs.getString("PASS"));
                admin.setQuestion(rs.getString("QUESTION"));
                admin.setAnswer(rs.getString("ANSWER"));   
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return admin;
    }
    
    public static void Update(Admin admin) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = sdf.format(admin.getDob());
        String query = "UPDATE ADMIN SET NAME = '" + admin.getName() + "', D_O_B = STR_TO_DATE('" 
                + date + "', '%d-%m-%Y'), GENDER = '" + admin.getGender() + "', ADDRESS = '" 
                + admin.getAddress() +  "', PHONE = '" + admin.getPhone() +  "', EMAIL = '" 
                + admin.getEmail() + "', PASS = '" + admin.getPass() + "', QUESTION = '" 
                + admin.getQuestion() + "', ANSWER = '" + admin.getAnswer() + "' WHERE ID = 1 ";
        DbOperations.setDataOrDelete (query, "Admin Updated Complete");
    }
    
    public static Admin SearchForEmail(String email) {
            Admin admin = null;
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM ADMIN WHERE EMAIL = '" + email + "'");
            while (rs.next()) {
                admin = new Admin();
                admin.setId(rs.getInt("ID"));
                admin.setName(rs.getString("NAME"));
                admin.setDob(rs.getDate("D_O_B"));
                admin.setGender(rs.getString("GENDER"));
                admin.setAddress(rs.getString("ADDRESS"));
                admin.setPhone(rs.getString("PHONE"));
                admin.setEmail(rs.getString("EMAIL"));
                admin.setPass(rs.getString("PASS"));
                admin.setQuestion(rs.getString("QUESTION"));
                admin.setAnswer(rs.getString("ANSWER"));  
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return admin;
    }
    
    public static Admin SearchForID( ) {
            Admin admin = null;
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM ADMIN WHERE ID = 1 ");
            while (rs.next()) {
                admin = new Admin();
                admin.setId(rs.getInt("ID"));
                admin.setName(rs.getString("NAME"));
                admin.setDob(rs.getDate("D_O_B"));
                admin.setGender(rs.getString("GENDER"));
                admin.setAddress(rs.getString("ADDRESS"));
                admin.setPhone(rs.getString("PHONE"));
                admin.setEmail(rs.getString("EMAIL"));
                admin.setPass(rs.getString("PASS"));
                admin.setQuestion(rs.getString("QUESTION"));
                admin.setAnswer(rs.getString("ANSWER"));  
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return admin;
    }
}
