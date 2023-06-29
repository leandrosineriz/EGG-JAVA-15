/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Casa;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author itsmi
 */
public class CasaDAO extends DAO {
    
    public Casa BuscarCasa(int id_casa) throws Exception{
        try {
            String sql = "Select id_casa,calle,numero,codigo_postal,ciudad,pais,fecha_desde,fecha_hasta,tiempo_minimo,"
                    + "tiempo_maximo,precio_habitacion,tipo_vivienda from casas where id_casa="+id_casa+";";
            consultarBase(sql);
            Casa casa = null;
            
            while (resultado.next()) {
               casa = new Casa();
               casa.setId_casa(resultado.getInt(1));
               casa.setCalle(resultado.getString(2));
               casa.setNumero(resultado.getInt(3));
               casa.setCodigo_postal(resultado.getString(4));
               casa.setCiudad(resultado.getString(5));
               casa.setPais(resultado.getString(6));
               casa.setFecha_desde(resultado.getDate(7));
               casa.setFecha_hasta(resultado.getDate(8));
               casa.setTiempo_minimo(resultado.getInt(9));
               casa.setTiempo_maximo(resultado.getInt(10));
               casa.setTipo_vivienda(resultado.getString(11));
            }
            desconectarBase();
            return casa;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
    
    public List<Casa> ListarCasas() throws Exception{
        try {
            String sql = "Select id_casa,calle,numero,codigo_postal,ciudad,pais,fecha_desde,fecha_hasta,tiempo_minimo,"
                    + "tiempo_maximo,precio_habitacion,tipo_vivienda from casas;";
            consultarBase(sql);
            Casa casa = null;
            List<Casa> casas = new ArrayList();
            
            while (resultado.next()) {
               casa = new Casa();
               casa.setId_casa(resultado.getInt(1));
               casa.setCalle(resultado.getString(2));
               casa.setNumero(resultado.getInt(3));
               casa.setCodigo_postal(resultado.getString(4));
               casa.setCiudad(resultado.getString(5));
               casa.setPais(resultado.getString(6));
               casa.setFecha_desde(resultado.getDate(7));
               casa.setFecha_hasta(resultado.getDate(8));
               casa.setTiempo_minimo(resultado.getInt(9));
               casa.setTiempo_maximo(resultado.getInt(10));
               casa.setTipo_vivienda(resultado.getString(11));
               
               casas.add(casa);
            }
            desconectarBase();
            return casas;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
    
    
    public List<Casa> ListarCasas(String periodoInicio,String periodoFin) throws Exception{
        try {
            String sql = "Select id_casa,calle,numero,codigo_postal,ciudad,pais,fecha_desde,fecha_hasta,tiempo_minimo,"
                    + "tiempo_maximo,precio_habitacion,tipo_vivienda from casas"
                    + " where fecha_desde>='"+periodoInicio+"' and fecha_hasta<='"+periodoFin+"';";
            //System.out.println(sql);
            consultarBase(sql);
            Casa casa = null;
            List<Casa> casas = new ArrayList();
            
            while (resultado.next()) {
               casa = new Casa();
               casa.setId_casa(resultado.getInt(1));
               casa.setCalle(resultado.getString(2));
               casa.setNumero(resultado.getInt(3));
               casa.setCodigo_postal(resultado.getString(4));
               casa.setCiudad(resultado.getString(5));
               casa.setPais(resultado.getString(6));
               casa.setFecha_desde(resultado.getDate(7));
               casa.setFecha_hasta(resultado.getDate(8));
               casa.setTiempo_minimo(resultado.getInt(9));
               casa.setTiempo_maximo(resultado.getInt(10));
               casa.setTipo_vivienda(resultado.getString(11));
               
               casas.add(casa);
            }
            desconectarBase();
            return casas;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
    
    public List<Casa> ListarCasas(String periodoInicio,int intervalo) throws Exception{
        try {
            String sql = "Select id_casa,calle,numero,codigo_postal,ciudad,pais,fecha_desde,fecha_hasta,tiempo_minimo,"
                    + "tiempo_maximo,precio_habitacion,tipo_vivienda from casas"
                    + " where fecha_desde>='"+periodoInicio+"' and fecha_hasta<=DATE_ADD('"+periodoInicio+"', INTERVAL "+intervalo+" DAY);";
            //System.out.println(sql);
            consultarBase(sql);
            Casa casa = null;
            List<Casa> casas = new ArrayList();
            
            while (resultado.next()) {
               casa = new Casa();
               casa.setId_casa(resultado.getInt(1));
               casa.setCalle(resultado.getString(2));
               casa.setNumero(resultado.getInt(3));
               casa.setCodigo_postal(resultado.getString(4));
               casa.setCiudad(resultado.getString(5));
               casa.setPais(resultado.getString(6));
               casa.setFecha_desde(resultado.getDate(7));
               casa.setFecha_hasta(resultado.getDate(8));
               casa.setTiempo_minimo(resultado.getInt(9));
               casa.setTiempo_maximo(resultado.getInt(10));
               casa.setTipo_vivienda(resultado.getString(11));
               
               casas.add(casa);
            }
            desconectarBase();
            return casas;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
}
