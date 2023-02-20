/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import Model.Appointment;
import Model.Bill;
import Model.Doctor;
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
public class FunctionPatient {
    
    public static Patient Login(String email, String password) {
            Patient patient = null;
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM PATIENT WHERE EMAIL = '" + email + "' AND PASS = '" + password + "'");
            while (rs.next()) {
                patient = new Patient();
                patient.setId(rs.getInt("ID"));
                patient.setName(rs.getString("NAME"));
                patient.setDob(rs.getDate("D_O_B"));
                patient.setGender(rs.getString("GENDER"));
                patient.setAddress(rs.getString("ADDRESS"));
                patient.setPhone(rs.getString("PHONE"));
                patient.setEmail(rs.getString("EMAIL"));
                patient.setPass(rs.getString("PASS"));
                patient.setQuestion(rs.getString("QUESTION"));
                patient.setAnswer(rs.getString("ANSWER")); 
                patient.setBlood_group(rs.getString("BLOOD_GROUP")); 
                patient.setStatus(rs.getString("STATUS"));  
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return patient;
    }
    
    public static void Register(Patient patient) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = sdf.format(patient.getDob());
        String query = "INSERT INTO PATIENT(NAME, D_O_B, GENDER, ADDRESS, PHONE, BLOOD_GROUP, EMAIL, PASS, QUESTION,ANSWER,STATUS) VALUES('" + patient.getName() + "', STR_TO_DATE('" + date + "', '%d-%m-%Y'), '" + patient.getGender() + "', '" + patient.getAddress() + "', '" + patient.getPhone() + "', '" + patient.getBlood_group() + "', '" + patient.getEmail() + "', '" + patient.getPass() + "', '" + patient.getQuestion() + "', '" + patient.getAnswer() + "', 'FALSE')";
        DbOperations.setDataOrDelete(query, "Successful Registration Please Wait For Admin To  Accept");
    }
    
    public static ArrayList<Patient> GetAllRecords() {
        ArrayList<Patient> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM PATIENT WHERE STATUS = 'TRUE'");
            while(rs.next()) {
                Patient patient = new Patient();
                patient.setId(rs.getInt("ID"));
                patient.setName(rs.getString("NAME"));
                patient.setDob(rs.getDate("D_O_B"));
                patient.setGender(rs.getString("GENDER"));
                patient.setAddress(rs.getString("ADDRESS"));
                patient.setPhone(rs.getString("PHONE"));
                patient.setBlood_group(rs.getString("BLOOD_GROUP"));
                patient.setEmail(rs.getString("EMAIL"));
                patient.setPass(rs.getString("PASS"));
                patient.setQuestion(rs.getString("QUESTION"));
                patient.setAnswer(rs.getString("ANSWER"));
                patient.setStatus("TRUE");
                arrayList.add(patient);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static ArrayList<Patient> GetAllRequest() {
        ArrayList<Patient> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM PATIENT WHERE STATUS = 'FALSE'");
            while(rs.next()) {
                Patient patient = new Patient();
                patient.setId(rs.getInt("ID"));
                patient.setName(rs.getString("NAME"));
                patient.setDob(rs.getDate("D_O_B"));
                patient.setGender(rs.getString("GENDER"));
                patient.setAddress(rs.getString("ADDRESS"));
                patient.setPhone(rs.getString("PHONE"));
                patient.setBlood_group(rs.getString("BLOOD_GROUP"));
                patient.setEmail(rs.getString("EMAIL"));
                patient.setPass(rs.getString("PASS"));
                patient.setQuestion(rs.getString("QUESTION"));
                patient.setAnswer(rs.getString("ANSWER"));
                patient.setStatus(rs.getString("STATUS"));
                arrayList.add(patient);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    return arrayList;
    }
    
    public static void Update(Patient patient) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = sdf.format(patient.getDob());
        String query = "UPDATE PATIENT SET NAME = '" + patient.getName() + "', D_O_B = STR_TO_DATE('" + date + "', '%d-%m-%Y'), GENDER = '" + patient.getGender() + "', ADDRESS = '" + patient.getAddress() +  "', PHONE = '" + patient.getPhone() + "', BLOOD_GROUP = '" + patient.getBlood_group() + "', EMAIL = '" + patient.getEmail() + "', PASS = '" + patient.getPass() + "', QUESTION = '" + patient.getQuestion() + "', ANSWER = '" + patient.getAnswer() + "', STATUS = '" + patient.getStatus() + "' WHERE ID = " + patient.getId() + " ";
        DbOperations.setDataOrDelete (query, "Patient Updated Complete");
    }
    
    public static void Delete(int did) {
        String query = "DELETE FROM PATIENT WHERE ID = "+ did +" ";
        DbOperations.setDataOrDelete (query, "Patient Deleted Complete");
    }
    
    public static void Add(Patient patient) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = sdf.format(patient.getDob());
        String query = "INSERT INTO PATIENT(NAME, D_O_B, GENDER, ADDRESS, PHONE, BLOOD_GROUP, EMAIL,PASS, QUESTION,ANSWER,STATUS) VALUES('" + patient.getName() + "', STR_TO_DATE('" + date + "', '%d-%m-%Y'), '" + patient.getGender() + "', '" + patient.getAddress() + "', '" + patient.getPhone() + "', '" + patient.getBlood_group() + "', '" + patient.getEmail() + "', '" + patient.getPass() + "', '" + patient.getQuestion() + "', '" + patient.getAnswer() + "', 'TRUE')";
        DbOperations.setDataOrDelete(query, "Successful Registration");
    }
    
    public static Patient SearchForID(int id) {
            Patient patient = null;
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM PATIENT WHERE ID = '" + id + "'");
            while (rs.next()) {
                patient = new Patient();
                patient.setId(rs.getInt("ID"));
                patient.setName(rs.getString("NAME"));
                patient.setDob(rs.getDate("D_O_B"));
                patient.setGender(rs.getString("GENDER"));
                patient.setAddress(rs.getString("ADDRESS"));
                patient.setPhone(rs.getString("PHONE"));
                patient.setEmail(rs.getString("EMAIL"));
                patient.setPass(rs.getString("PASS"));
                patient.setQuestion(rs.getString("QUESTION"));
                patient.setAnswer(rs.getString("ANSWER"));  
                patient.setBlood_group(rs.getString("BLOOD_GROUP")); 
                patient.setStatus(rs.getString("STATUS"));  
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return patient;
    }
    public static ArrayList<Appointment> GetAllAppointment(int patient_id) {
        ArrayList<Appointment> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM APPOINTMENT WHERE PATIENT_ID = " + patient_id + " ");
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
    
    public static ArrayList<Bill> GetAllBill(int pid) {
        ArrayList<Bill> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT A.PATIENT_ID,A.DOCTOR_ID,A.SYMPTOM,A.BACKGROUND_DISEASE,A.DIAGNOSE,A.DAY_APPOINT,A.START,A.END,B.ID AS BILL_ID, B. APPOINTMENT_ID, B.DAY_CREATED, B.TOTAL_PRICE FROM APPOINTMENT AS A INNER JOIN BILL AS B WHERE A.ID = B.APPOINTMENT_ID AND A.PATIENT_ID = " + pid + " ");
            while(rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("BILL_ID"));
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
}
