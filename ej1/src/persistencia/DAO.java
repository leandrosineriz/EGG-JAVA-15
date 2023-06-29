/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author itsmi
 */
public abstract class DAO {
    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;
    
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "nba";
    
    protected void conectarBase() throws SQLException {
        try {
            String url= "jdbc:mysql://localhost:3306/"+DATABASE+"?useSSL=false";
            conexion = DriverManager.getConnection(url, USER, PASSWORD);
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
    protected void desconectarBase() throws SQLException {
        try {
            if (resultado!=null) {
                resultado.close();
            }
            if (sentencia!=null) {
                sentencia.close();
            }
            if (conexion!=null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
    protected void insertarModificarEliminar(String sql) throws SQLException {
        try {
            this.conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            // conexion.rollback();
            /* 
                Descomentar la linea anterior si desean tener en cuenta el rollback.
                Correr el siguiente Script en workbench

                SET autocommit = 1;
                COMMIT;
                **sin rollback igual anda
            */
            throw ex;
        } finally {
            desconectarBase();
        }
    }
    
    protected void consultarBase(String sql) throws SQLException {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException ex) {
            throw ex;
        }
    }
}
