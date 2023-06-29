/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testconeccion;

import java.sql.*;

/**
 *
 * @author itsmi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            String url= "jdbc:mysql://localhost:3306/pokemondb";
            Connection con = DriverManager.getConnection(url, "root", "root");
            String sql = "select * from pokemon;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getInt(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
