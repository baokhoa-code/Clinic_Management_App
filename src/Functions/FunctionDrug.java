/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import Model.Drug;
import Model.Patient;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author khoa1
 */
public class FunctionDrug {
    
    public static ArrayList<Drug> GetAllRecords() {
        ArrayList<Drug> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM DRUG");
            while(rs.next()) {
                Drug drug = new Drug();
                drug.setId(rs.getInt("ID"));
                drug.setName(rs.getString("NAME"));
                drug.setCompany_name(rs.getString("COMPANY_NAME"));
                drug.setComposition(rs.getString("COMPOSITION"));
                drug.setMfg(rs.getDate("MFG"));
                drug.setExp(rs.getDate("EXP"));
                drug.setPrice(rs.getString("PRICE"));
                arrayList.add(drug);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static void Update(Drug drug) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String manu = sdf.format(drug.getMfg());
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
        String exp = sdf2.format(drug.getExp());
        String query = "UPDATE DRUG SET NAME = '" + drug.getName() + "', COMPANY_NAME = '" + drug.getCompany_name() + "', COMPOSITION = '" + drug.getComposition() + "', MFG = STR_TO_DATE('" + manu + "', '%d-%m-%Y'), EXP = STR_TO_DATE('" + exp + "', '%d-%m-%Y'), PRICE = '" + drug.getPrice() + "' WHERE ID = " + drug.getId() + " ";
        DbOperations.setDataOrDelete (query, "Drug Updated Complete");
    }
    
    public static void Delete(int did) {
        String query = "DELETE FROM DRUG WHERE ID = "+ did +" ";
        DbOperations.setDataOrDelete (query, "Drug Deleted Complete");
    }
    
    public static void Add(Drug drug) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String manu = sdf.format(drug.getMfg());
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
        String exp = sdf2.format(drug.getExp());
        String query = "INSERT INTO DRUG (NAME, COMPANY_NAME, COMPOSITION, MFG, EXP, PRICE) VALUES('" + drug.getName() + "','" + drug.getCompany_name() + "','" + drug.getComposition() +  "', STR_TO_DATE('" + manu + "', '%d-%m-%Y'),  STR_TO_DATE('" + exp + "', '%d-%m-%Y'),'" + drug.getPrice() + "')";
        DbOperations.setDataOrDelete(query, "Successful Registration");
    }
    
    public static Drug SearchForID(int id) {
            Drug drug = null;
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM DRUG WHERE ID = '" + id + "'");
            while (rs.next()) {
                drug= new Drug();
                drug.setId(rs.getInt("ID"));
                drug.setName(rs.getString("NAME"));
                drug.setCompany_name(rs.getString("COMPANY_NAME"));
                drug.setComposition(rs.getString("COMPOSITION"));
                drug.setMfg(rs.getDate("MFG"));
                drug.setExp(rs.getDate("EXP"));
                drug.setPrice(rs.getString("PRICE"));
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return drug;
    }
    
}
