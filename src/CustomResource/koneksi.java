/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomResource;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





/**
 *
 * @author lutfi wijaya
 */
public class koneksi {
    
     //cek apakah koneksi null
    private static Connection koneksi;
    
    public static Connection getConnection(){
     //cek apakah koneksi null
        if(koneksi == null){
            String asd = "lutpi";
            if (asd == "lutpi") {
                try{
                String url = "jdbc:mysql://localhost/achivonapp";
                String user = "root";
                String password = "";

                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("Connected");
            }catch (SQLException t){
                System.out.println(t);
            }
            }else{
                try{
                String url = "jdbc:mysql://192.168.8.111/achivonapp";
                String user = "wm";
                String password = "qwe";

                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("Connected");
            }catch (SQLException t){
                System.out.println(t);
            }
        }
    }
        return koneksi;
    }
}