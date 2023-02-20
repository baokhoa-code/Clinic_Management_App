/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import Model.Appointment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author khoa1
 */
public class FunctionAppointment {
    
    public static ArrayList<Appointment> GetAllRecords() {
        ArrayList<Appointment> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM APPOINTMENT");
            while(rs.next()) {
                Appointment appoint = new Appointment();
                appoint.setId(rs.getInt("ID"));
                appoint.setPatient_id(rs.getInt("PATIENT_ID"));
                appoint.setDoctor_id(rs.getInt("DOCTOR_ID"));
                appoint.setSymptom(rs.getString("SYMPTOM"));
                appoint.setBackground_disease(rs.getString("BACKGROUND_DISEASE"));
                appoint.setDiagnose(rs.getString("DIAGNOSE"));
                appoint.setDate_appoint(rs.getDate("DAY_APPOINT"));
                appoint.setStart(rs.getInt("START"));
                appoint.setEnd(rs.getInt("END"));
                appoint.setStatus(rs.getString("STATUS"));
                arrayList.add(appoint);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static void Update(Appointment appoint) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = sdf.format(appoint.getDate_appoint());
        String query = "UPDATE APPOINTMENT SET PATIENT_ID = '" + appoint.getPatient_id() + "',DOCTOR_ID = '" + appoint.getDoctor_id() + "',SYMPTOM = '" + appoint.getSymptom() + "',BACKGROUND_DISEASE = '" + appoint.getBackground_disease() + "',DIAGNOSE = '" + appoint.getDiagnose() + "',DAY_APPOINT = STR_TO_DATE('" + date + 
                "', '%d-%m-%Y'), START = " + appoint.getStart() + ",END = " + appoint.getEnd() + " WHERE ID = " + appoint.getId() + " ";
        DbOperations.setDataOrDelete (query, "Appointment Updated Complete");
    }
    
    public static void Delete(int did) {
        String query = "DELETE FROM APPOINTMENT WHERE ID = " + did + " ";
        DbOperations.setDataOrDelete (query, "Appointment Deleted Complete");
    }
    
    public static void Add(Appointment appoint) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = sdf.format(appoint.getDate_appoint());
        String query = "INSERT INTO APPOINTMENT (PATIENT_ID,DOCTOR_ID, SYMPTOM, BACKGROUND_DISEASE, DIAGNOSE,DAY_APPOINT,START,END,STATUS) VALUES(" + appoint.getPatient_id() + "," + appoint.getDoctor_id() + ",'" + appoint.getSymptom() + "','" + appoint.getBackground_disease() + "','" + appoint.getDiagnose() + "', STR_TO_DATE('" + date + "', '%d-%m-%Y')," + appoint.getStart() + "," + appoint.getEnd() + ",'HAVE NOT BILL')";
        DbOperations.setDataOrDelete(query, "Successful Registration");
    }
    
    public static Appointment SearchForID(int id) {
        Appointment appoint = null;
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM APPOINTMENT WHERE ID = '" + id + "'");
            while (rs.next()) {
                appoint = new Appointment();
                appoint.setId(rs.getInt("ID"));
                appoint.setPatient_id(rs.getInt("PATIENT_ID"));
                appoint.setDoctor_id(rs.getInt("DOCTOR_ID"));
                appoint.setSymptom(rs.getString("SYMPTOM"));
                appoint.setBackground_disease(rs.getString("BACKGROUND_DISEASE"));
                appoint.setDiagnose(rs.getString("DIAGNOSE"));
                appoint.setDate_appoint(rs.getDate("DAY_APPOINT"));
                appoint.setStart(rs.getInt("START"));
                appoint.setEnd(rs.getInt("END"));
                appoint.setStatus(rs.getString("STATUS"));
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return appoint;
    }
    
    public static void ChangeStatus(int id){
        Appointment appoint = null;
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM APPOINTMENT WHERE ID = '" + id + "'");
            while (rs.next()) {
                appoint = new Appointment();
                appoint.setId(rs.getInt("ID"));
                appoint.setPatient_id(rs.getInt("PATIENT_ID"));
                appoint.setDoctor_id(rs.getInt("DOCTOR_ID"));
                appoint.setSymptom(rs.getString("SYMPTOM"));
                appoint.setBackground_disease(rs.getString("BACKGROUND_DISEASE"));
                appoint.setDiagnose(rs.getString("DIAGNOSE"));
                appoint.setDate_appoint(rs.getDate("DAY_APPOINT"));
                appoint.setStart(rs.getInt("START"));
                appoint.setEnd(rs.getInt("END"));
                appoint.setStatus(rs.getString("STATUS"));
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        if(appoint.getStatus().equals("HAVE NOT BILL")){
            String query = "UPDATE APPOINTMENT SET STATUS = 'HAVE BILL'  WHERE ID = " + id + " ";
            DbOperations.setDataOrDelete (query, "");
        }else{
            String query = "UPDATE APPOINTMENT SET STATUS = 'HAVE NOT BILL'  WHERE ID = " + id + " ";
            DbOperations.setDataOrDelete (query, "");
        }
    }
}
