/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbaihat.controller;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author TRAN HAI DANG
 */
public class DataBase {
        public static java.sql.Connection getConnection(){
        java.sql.Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bai_tap_lon_opp?useSSL=false&useUnicode=true&characterEncoding=UTF-8", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public static void main(String[] args) {
        System.out.println(getConnection());
    }
    
}
