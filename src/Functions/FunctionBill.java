/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import Model.Doctor;
import Model.Drug;
import Model.Bill;
import Model.BillDetail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author khoa1
 */
public class FunctionBill {
    
    public static ArrayList<Bill> GetAllRecords() {
        ArrayList<Bill> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM BILL");
            while(rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("ID"));
                bill.setAppointment_id(rs.getInt("APPOINTMENT_ID"));
                bill.setDay_created(rs.getTimestamp("DAY_CREATED"));
                bill.setTotal_price(rs.getString("TOTAL_PRICE"));
                arrayList.add(bill);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
     
    public static void Delete(int did) {
        String query = "DELETE FROM BILL WHERE ID = "+ did +" ";
        DbOperations.setDataOrDelete (query, "Prescription Deleted Complete");
    }
     
    public static void DeleteNoMess(int did) {
        String query = "DELETE FROM BILL WHERE ID = "+ did +" ";
        DbOperations.setDataOrDelete (query, "");
    }
    
    public static Bill SearchForID(int id) {
            Bill bill = null;
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM BILL WHERE ID = '" + id + "'");
            while (rs.next()) {
                bill = new Bill();
                bill.setId(rs.getInt("ID"));
                bill.setAppointment_id(rs.getInt("APPOINTMENT_ID"));
                bill.setDay_created(rs.getTimestamp("DAY_CREATED"));
                bill.setTotal_price(rs.getString("TOTAL_PRICE")); 
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return bill;
    } 
    
    public static void Add(Bill bill) {
        String query = "INSERT INTO BILL (APPOINTMENT_ID, DAY_CREATED, TOTAL_PRICE) VALUES(" + bill.getAppointment_id() + ", CURRENT_TIME(), '" + bill.getTotal_price() + "')";
        DbOperations.setDataOrDelete(query, "Successful Registration");
    }
    
    public static void Update(int id, int total) {
        String query = "UPDATE BILL SET TOTAL_PRICE = '" + total + "' WHERE ID = " + id + " ";
        DbOperations.setDataOrDelete (query, "Prescription Updated Complete");
        
    }
    
    public static void UpdateTotal(int id, int total) {
        String query = "UPDATE BILL SET TOTAL_PRICE = '" + total + "' WHERE ID = " + id + " ";
        DbOperations.setDataOrDelete (query, "");
        
    }
    
    public static int FindNearestID(){
        Bill bill = new Bill();
        try {
            ResultSet rs = DbOperations.getData("SELECT MAX(ID) AS MAXID FROM BILL ");
            while(rs.next()) {
                bill.setId(rs.getInt("MAXID"));
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return bill.getId();
    }
    
}
