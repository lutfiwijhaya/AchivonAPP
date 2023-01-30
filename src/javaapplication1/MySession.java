/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;
/**
 *
 * @author hi
 */
//package javasession;

public class MySession {
    private static String ktp;
    private static String nama;
    
    public static String get_ktp(){
        return ktp;
    }
    
    public static void set_ktp(String ktp){
        MySession.ktp = ktp;
    }
    
    public static String get_nama(){
        return nama;
    }
    
    public static void set_nama(String nama){
        MySession.nama = nama;
    }
}
