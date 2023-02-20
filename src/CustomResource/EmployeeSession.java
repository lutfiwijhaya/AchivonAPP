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
    private static String KTPClearance;
    private static String KTPHandover;
    
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
}
