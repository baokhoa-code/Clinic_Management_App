/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import Model.Doctor;
import Model.Drug;
import Model.FreeSchedule;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author khoa1
 */
public class FunctionFreeSchedule {
    
    public static ArrayList<FreeSchedule> GetAllRecords() {
        ArrayList<FreeSchedule> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM FREE_SCHEDULE");
            while(rs.next()) {
                FreeSchedule free = new FreeSchedule();
                free.setId(rs.getInt("ID"));
                free.setDid(rs.getInt("DOCTOR_ID"));
                free.setDay_free(rs.getString("DAY_FREE"));
                free.setTime_start(rs.getInt("TIME_START"));
                free.setTime_end(rs.getInt("TIME_END"));
                arrayList.add(free);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static void Update(FreeSchedule free) {
        String query = "UPDATE FREE_SCHEDULE SET DOCTOR_ID = '" + free.getDid() + "', DAY_FREE =  '" + free.getDay_free() + "', TIME_START = '" + free.getTime_start() + "',TIME_END = '" + free.getTime_end() + "' WHERE ID = '" + free.getId() + "'";
        DbOperations.setDataOrDelete (query, "FreeSchedule Updated Complete");
    }
    
    public static void Delete(int did) {
        String query = "DELETE FROM FREE_SCHEDULE WHERE ID = " + did + " ";
        DbOperations.setDataOrDelete (query, "FreeSchedule Deleted Complete");
    }
    
    public static void Add(FreeSchedule free) {
        String query = "INSERT INTO FREE_SCHEDULE (DOCTOR_ID, DAY_FREE, TIME_START, TIME_END) VALUES(" + free.getDid() + ", '" + free.getDay_free() + "', " + free.getTime_start() + "," + free.getTime_end() + ")";
        DbOperations.setDataOrDelete(query, "Successful Registration");
    }
    
    public static FreeSchedule SearchForID(int id) {
            FreeSchedule free = null;
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM FREE_SCHEDULE WHERE ID = '" + id + "'");
            while (rs.next()) {
                free= new FreeSchedule();
                free.setId(rs.getInt("ID"));
                free.setDid(rs.getInt("DOCTOR_ID"));
                free.setDay_free(rs.getString("DAY_FREE"));
                free.setTime_start(rs.getInt("TIME_START"));
                free.setTime_end(rs.getInt("TIME_END"));
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return free;
    }
    
    public static ArrayList<FreeSchedule> GetIDDoctorOnTime(String tdate, int start, int end) {
        ArrayList<FreeSchedule> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM FREE_SCHEDULE WHERE DAY_FREE = '" + tdate + "' AND TIME_START <= " + start + " AND TIME_END >= " + end + " ");
            while(rs.next()) {
                FreeSchedule free = new FreeSchedule();  
                free.setDid(rs.getInt("DOCTOR_ID"));
                arrayList.add(free);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
}
