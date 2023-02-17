/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomResource;

public class EmployeeSession {
    private static String EmployeeID;
    private static String KTP;
    
    public static String getEmployeeID(){
        return EmployeeID;
    }
    
    public static void setEmployeeID(String EmployeeID){
        EmployeeSession.EmployeeID = EmployeeID;
    }
    
    public static String getKTP(){
        return KTP;
    }
    
    public static void setKTP(String KTP){
        EmployeeSession.KTP = KTP;
    }
}
