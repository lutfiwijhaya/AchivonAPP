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
    private static String CandidateNama;
    private static String CandidateEmail;
    private static String CandidateNoHP;
//    private static String CandidateID;
    
    public static String getCandidateID(){
        return CandidateID;
    }
    
    public static void setCandidateID(String CandidateID){
        CandidateSession.CandidateID = CandidateID;
    }
    public static String getCandidateNama(){
        return CandidateNama;
    }
    
    public static void setCandidateNama(String CandidateNama){
        CandidateSession.CandidateNama = CandidateNama;
    }
    public static String getCandidateEmail(){
        return CandidateEmail;
    }
    
    public static void setCandidateEmail(String CandidateEmail){
        CandidateSession.CandidateEmail = CandidateEmail;
    }
    public static String getCandidateNoHP(){
        return CandidateNoHP;
    }
    
    public static void setCandidateNoHP(String CandidateNoHP){
        CandidateSession.CandidateNoHP = CandidateNoHP;
    }
}
