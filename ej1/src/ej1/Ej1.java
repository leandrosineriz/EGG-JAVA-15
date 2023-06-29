/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author itsmi
 */
public class Ej1 {

    /**
     * @param args the command line arguments
     */private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "nba";
    
    public static void main(String[] args) {
        // TODO code application logic here
        int i=0;
        try {
            String url= "jdbc:mysql://localhost:3306/pokemondb";
            Connection con = DriverManager.getConnection(url, "root", "root");
            String sql = "UPDATE pokemon SET nombre='test' WHERE numero_pokedex = 1;";
            while (true) {
                Statement stmt = con.createStatement();
                stmt.executeUpdate(sql);
                i++;
                System.out.println(i);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error");
        }
    
    
    }
    
    
}
