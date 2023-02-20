/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import Model.Bill;
import Model.BillDetail;
import Model.Drug;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author khoa1
 */
public class FunctionBillDetail {
    
    public static ArrayList<BillDetail> GetAllRecords() {
        ArrayList<BillDetail> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM BILL_DETAIL");
            while(rs.next()) {
                BillDetail billdetail = new BillDetail();
                billdetail.setBid(rs.getInt("BILL_ID"));
                billdetail.setDid(rs.getInt("DRUG_ID"));
                billdetail.setName(rs.getString("NAME"));
                billdetail.setPrice(rs.getString("PRICE"));
                billdetail.setQuantity(rs.getInt("QUANTITY"));
                billdetail.setTotal(rs.getString("TOTAL"));
                arrayList.add(billdetail);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static ArrayList<BillDetail> GetAllRecordsForBillID(int bid) {
        ArrayList<BillDetail> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM BILL_DETAIL WHERE BILL_ID = " + bid + " ");
            while(rs.next()) {
                BillDetail billdetail = new BillDetail();
                billdetail.setBid(rs.getInt("BILL_ID"));
                billdetail.setDid(rs.getInt("DRUG_ID"));
                billdetail.setName(rs.getString("NAME"));
                billdetail.setPrice(rs.getString("PRICE"));
                billdetail.setQuantity(rs.getInt("QUANTITY"));
                billdetail.setTotal(rs.getString("TOTAL"));
                arrayList.add(billdetail);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static void Delete(int bid, int did) {
        String query = "DELETE FROM BILL_DETAIL WHERE BILL_ID = "+ bid +" AND DRUG_ID = " + did + " ";
        DbOperations.setDataOrDelete (query, "PrescriptionDetail Deleted Complete");
    }
    
    public static void DeleteForBillID(int bid) {
        String query = "DELETE FROM BILL_DETAIL WHERE BILL_ID = "+ bid + " ";
        DbOperations.setDataOrDelete (query, "");
    }
    
    public static void Update(BillDetail billdetail) {
        String query = "UPDATE BILL_DETAIL SET Quantity = " + billdetail.getQuantity() + ", TOTAL = '" + billdetail.getTotal() + "' WHERE BILL_ID = " + billdetail.getBid() + " AND DRUG_ID = " + billdetail.getDid() + " ";
        DbOperations.setDataOrDelete (query, "Prescription Updated Complete");
        
    }
    
    public static void Add(BillDetail billdetail) {
        String query = "INSERT INTO BILL_DETAIL (BILL_ID, DRUG_ID, NAME, PRICE, QUANTITY, TOTAL) VALUES(" + billdetail.getBid() + "," + billdetail.getDid() + ", '" + billdetail.getName() + "', '" + billdetail.getPrice() + "', " + billdetail.getQuantity() + ", '" + billdetail.getTotal() + "')";
        try {
            Connection con = ConnectionSql.getCon();
            Statement st = con.createStatement();
            st.executeUpdate(query);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);    
        }
    }
    
    public static BillDetail SearchForID(int bid, int did) {
            BillDetail billdetail = null;
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM BILL_DETAIL WHERE BILL_ID = " + bid + " AND DRUG_ID = " + did +" ");
            while (rs.next()) {
                billdetail= new BillDetail();
                billdetail.setBid(rs.getInt("BILL_ID"));
                billdetail.setDid(rs.getInt("DRUG_ID"));
                billdetail.setName(rs.getString("NAME"));
                billdetail.setPrice(rs.getString("PRICE"));
                billdetail.setQuantity(rs.getInt("Quantity"));                
                billdetail.setTotal(rs.getString("TOTAL"));
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return billdetail;
    }
    
}
