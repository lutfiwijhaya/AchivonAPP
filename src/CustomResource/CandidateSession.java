/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomResource;

/**
 *
 * @author hi
 */
public class CandidateSession {
 
    private static String CandidateID;
    
    public static String getCandidateID(){
        return CandidateID;
    }
    
    public static void setCandidateID(String CandidateID){
        CandidateSession.CandidateID = CandidateID;
    }
}
