/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rafli
 */
public class koneksi {
    private Connection koneksi;
    public Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Berhasil membuat Koneksi");
        }catch (ClassNotFoundException ex){
            System.out.println("Gagal koneksi" + ex);
        }
        String url = "jdbc:mysql://localhost/klinikmasbahlilganteng";
        try{
            koneksi = DriverManager.getConnection(url,"root","");
            System.out.println("Berhasil Terhubung ke Database");
        } catch (SQLException ex){
            System.out.println("Gagal Terhubung Database" + ex);
        }
        
        return koneksi;
    }
}