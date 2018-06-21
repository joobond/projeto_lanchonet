/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ecles
 */
public class Conexao {
    private static Connection con;
    private static String URL = "jdbc:mysql://localhost:3306/db";
    private static String USER = "root";
    private static String PASS = "";
    
    private Conexao() {}
    
    public static Connection get() throws SQLException {
        if(con == null) {
            con = DriverManager.getConnection(URL, USER, PASS);
        }
        return con;
    }
}
