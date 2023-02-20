/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import Model.Appointment;
import Model.Bill;
import Model.Doctor;
import Model.FreeSchedule;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author khoa1
 */
public class FunctionDoctor {
    
    public static Doctor Login(String email, String password) {
            Doctor doctor = null;
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM DOCTOR WHERE EMAIL = '" + email + "' AND PASS = '" + password + "'");
            while (rs.next()) {
                doctor = new Doctor();
                doctor.setId(rs.getInt("ID"));
                doctor.setName(rs.getString("NAME"));
                doctor.setDob(rs.getDate("D_O_B"));
                doctor.setGender(rs.getString("GENDER"));
                doctor.setAddress(rs.getString("ADDRESS"));
                doctor.setPhone(rs.getString("PHONE"));
                doctor.setEmail(rs.getString("EMAIL"));
                doctor.setPass(rs.getString("PASS"));
                doctor.setQuestion(rs.getString("QUESTION"));
                doctor.setAnswer(rs.getString("ANSWER"));  
                doctor.setCertificate(rs.getString("CERTIFICATE")); 
                doctor.setSpecialist(rs.getString("SPECIALIST")); 
                doctor.setStatus(rs.getString("STATUS"));  
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return doctor;
    }
    
    public static void Register(Doctor doctor) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = sdf.format(doctor.getDob());
        String query = "INSERT INTO DOCTOR(NAME, D_O_B, GENDER, ADDRESS, PHONE, CERTIFICATE, SPECIALIST, EMAIL,PASS, "
                + "QUESTION,ANSWER,STATUS) VALUES('" + doctor.getName() + "', STR_TO_DATE('" + date + "', '%d-%m-%Y'), '" 
                + doctor.getGender() + "', '" + doctor.getAddress() + "', '" + doctor.getPhone() + "', '" 
                + doctor.getCertificate() + "', '" + doctor.getSpecialist() + "', '" + doctor.getEmail() + "', '" 
                + doctor.getPass() + "', '" + doctor.getQuestion() + "', '" + doctor.getAnswer() + "', 'FALSE')";
        DbOperations.setDataOrDelete(query, "Successful Registration Please Wait For Admin To  Accept");
    }
    
    public static ArrayList<Doctor> GetAllRecords() {
        ArrayList<Doctor> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM DOCTOR WHERE STATUS = 'TRUE'");
            while(rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setId(rs.getInt("ID"));
                doctor.setName(rs.getString("NAME"));
                doctor.setDob(rs.getDate("D_O_B"));
                doctor.setGender(rs.getString("GENDER"));
                doctor.setAddress(rs.getString("ADDRESS"));
                doctor.setPhone(rs.getString("PHONE"));
                doctor.setCertificate(rs.getString("CERTIFICATE"));
                doctor.setSpecialist(rs.getString("SPECIALIST"));
                doctor.setEmail(rs.getString("EMAIL"));
                doctor.setPass(rs.getString("PASS"));
                doctor.setQuestion(rs.getString("QUESTION"));
                doctor.setAnswer(rs.getString("ANSWER"));
                doctor.setStatus(rs.getString("STATUS"));
                arrayList.add(doctor);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    return arrayList;
    }
    
    public static ArrayList<Doctor> GetAllRequest() {
        ArrayList<Doctor> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM DOCTOR WHERE STATUS = 'FALSE'");
            while(rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setId(rs.getInt("ID"));
                doctor.setName(rs.getString("NAME"));
                doctor.setDob(rs.getDate("D_O_B"));
                doctor.setGender(rs.getString("GENDER"));
                doctor.setAddress(rs.getString("ADDRESS"));
                doctor.setPhone(rs.getString("PHONE"));
                doctor.setCertificate(rs.getString("CERTIFICATE"));
                doctor.setSpecialist(rs.getString("SPECIALIST"));
                doctor.setEmail(rs.getString("EMAIL"));
                doctor.setPass(rs.getString("PASS"));
                doctor.setQuestion(rs.getString("QUESTION"));
                doctor.setAnswer(rs.getString("ANSWER"));
                doctor.setStatus(rs.getString("STATUS"));
                arrayList.add(doctor);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    return arrayList;
    }
    
    public static void Update(Doctor doctor) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = sdf.format(doctor.getDob());
        String query = "UPDATE DOCTOR SET NAME = '" + doctor.getName() + "', D_O_B = STR_TO_DATE('" + date + "', '%d-%m-%Y'), GENDER = '" + doctor.getGender() + "', ADDRESS = '" + doctor.getAddress() +  "', PHONE = '" + doctor.getPhone() + "', CERTIFICATE = '" + doctor.getCertificate() + "', SPECIALIST = '" + doctor.getSpecialist() + "', EMAIL = '" + doctor.getEmail() + "', PASS = '" + doctor.getPass() + "', QUESTION = '" + doctor.getQuestion() + "', ANSWER = '" + doctor.getAnswer() + "', Status = '" + doctor.getStatus() + "' WHERE ID = " + doctor.getId() + " ";
        DbOperations.setDataOrDelete (query, "Doctor Updated Complete");
    }
    
    public static void Delete(int did) {
        String query = "DELETE FROM DOCTOR WHERE ID = "+ did +" ";
        DbOperations.setDataOrDelete (query, "Doctor Deleted Complete");
    }
    
    public static void Add(Doctor doctor) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = sdf.format(doctor.getDob());
        String query = "INSERT INTO DOCTOR(NAME, D_O_B, GENDER, ADDRESS, PHONE, CERTIFICATE, SPECIALIST, EMAIL,PASS, QUESTION,ANSWER,STATUS) VALUES('" + doctor.getName() + "', STR_TO_DATE('" + date + "', '%d-%m-%Y'), '" + doctor.getGender() + "', '" + doctor.getAddress() + "', '" + doctor.getPhone() + "', '" + doctor.getCertificate() + "', '" + doctor.getSpecialist() + "', '" + doctor.getEmail() + "', '" + doctor.getPass() + "', '" + doctor.getQuestion() + "', '" + doctor.getAnswer() + "', '" + doctor.getStatus() + "')";
        DbOperations.setDataOrDelete(query, "Successful Registration");
    }
    
    public static Doctor SearchForID(int id) {
            Doctor doctor = null;
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM DOCTOR WHERE ID = '" + id + "'");
            while (rs.next()) {
                doctor = new Doctor();
                doctor.setId(rs.getInt("ID"));
                doctor.setName(rs.getString("NAME"));
                doctor.setDob(rs.getDate("D_O_B"));
                doctor.setGender(rs.getString("GENDER"));
                doctor.setAddress(rs.getString("ADDRESS"));
                doctor.setPhone(rs.getString("PHONE"));
                doctor.setEmail(rs.getString("EMAIL"));
                doctor.setPass(rs.getString("PASS"));
                doctor.setQuestion(rs.getString("QUESTION"));
                doctor.setAnswer(rs.getString("ANSWER"));  
                doctor.setCertificate(rs.getString("CERTIFICATE")); 
                doctor.setSpecialist(rs.getString("SPECIALIST")); 
                doctor.setStatus(rs.getString("STATUS"));  
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return doctor;
    }
    
    public static ArrayList<FreeSchedule> GetAllFreeSchedule(int doctor_id) {
        ArrayList<FreeSchedule> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM FREE_SCHEDULE WHERE DOCTOR_ID = " + doctor_id + " ");
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
    
    public static ArrayList<Appointment> GetAllAppointment(int doctor_id) {
        ArrayList<Appointment> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM APPOINTMENT WHERE DOCTOR_ID = " + doctor_id + " ");
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
    
    public static ArrayList<Bill> GetAllBill(int doctor_id) {
        ArrayList<Bill> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT A.PATIENT_ID,A.DOCTOR_ID,A.SYMPTOM,A.BACKGROUND_DISEASE,A.DIAGNOSE,A.DAY_APPOINT,A.START,A.END,B.ID AS BILL_ID, B. APPOINTMENT_ID, B.DAY_CREATED, B.TOTAL_PRICE FROM APPOINTMENT AS A INNER JOIN BILL AS B WHERE A.ID = B.APPOINTMENT_ID AND A.DOCTOR_ID = " + doctor_id + " ");
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
