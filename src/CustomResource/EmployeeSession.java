/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomResource;

public class EmployeeSession {
    private static String EmployeeID;
    private static String KTPResign;
    private static String KTPRehab;
    private static String KTPAbsence;
    private static String KTPAllocation;
    private static String KTPSummary;
    private static String KTPClearance;
    private static String KTPHandover;
    private static String sesi_form;
    private static String biz_id;
    
    // sesi form : 1. 
    
    public static String getsesiform(){
        return sesi_form;
    }
    
    public static void setsesiform(String sesi_form){
        EmployeeSession.sesi_form = sesi_form;
    }
    public static String getEmployeeID(){
        return EmployeeID;
    }
    
    public static void setEmployeeID(String EmployeeID){
        EmployeeSession.EmployeeID = EmployeeID;
    }
    
    public static String getKTPResign(){
        return KTPResign;
    }
    
    public static void setKTPResign(String KTPResign){
        EmployeeSession.KTPResign = KTPResign;
    }
    
    public static String getKTPRehab(){
        return KTPRehab;
    }
    
    public static void setKTPRehab(String KTPRehab){
        EmployeeSession.KTPRehab = KTPRehab;
    }
    
    public static String getKTPAbsence(){
        return KTPAbsence;
    }
    
    public static void setKTPAbsence(String KTPAbsence){
        EmployeeSession.KTPAbsence = KTPAbsence;
    }
    
    
    public static String getKTPSummary(){
        return KTPSummary;
    }
    
    public static void setKTPSummary(String KTPSummary){
        EmployeeSession.KTPSummary = KTPSummary;
    }
    
    public static String getKTPAllocation(){
        return KTPAllocation;
    }
    
    public static void setKTPAllocation(String KTPAllocation){
        EmployeeSession.KTPAllocation = KTPAllocation;
    }
    
    public static String getKTPClearance(){
        return KTPClearance;
    }
    
    public static void setKTPClearance(String KTPClearance){
        EmployeeSession.KTPClearance = KTPClearance;
    }
    
    public static String getKTPHandover(){
        return KTPHandover;
    }
    
    public static void setKTPHandover(String KTPHandover){
        EmployeeSession.KTPHandover = KTPHandover;
    }
    
     public static String getbiz_id(){
        return biz_id;
    }
    
    public static void setbiz_id(String biz_id){
        EmployeeSession.biz_id = biz_id;
    }
    
    
}
