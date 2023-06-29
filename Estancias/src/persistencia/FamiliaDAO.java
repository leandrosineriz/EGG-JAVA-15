/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Familia;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author itsmi
 */
public class FamiliaDAO extends DAO {
    
    public Collection<Familia> listarFamilias() throws Exception{
        try {
            CasaDAO cd = new CasaDAO();
            String sql = "Select id_familia,nombre,edad_minima,edad_maxima,num_hijos,email,id_casa_familia from familias";
            consultarBase(sql);
            Familia familia;
            Collection<Familia> familias = new ArrayList();
            while (resultado.next()) {
               familia = new Familia();
               familia.setId(resultado.getInt(1));
               familia.setNombre(resultado.getString(2));
               familia.setEdad_minima(resultado.getInt(3));
               familia.setEdad_maxima(resultado.getInt(4));
               familia.setNum_hijos(resultado.getInt(5));
               familia.setEmail(resultado.getString(6));
               familia.setCasa_familia(cd.BuscarCasa(resultado.getInt(7)));
               
               familias.add(familia);
            }
            desconectarBase();
            return familias;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
    
    public Collection<Familia> listarFamilias(int hijos_max, int edad_maxima) throws Exception{
        try {
            CasaDAO cd = new CasaDAO();
            String sql = "Select id_familia,nombre,edad_minima,edad_maxima,num_hijos,email,id_casa_familia from familias"
                    + " where edad_maxima<="+edad_maxima+" and num_hijos<="+hijos_max;
            consultarBase(sql);
            Familia familia;
            Collection<Familia> familias = new ArrayList();
            while (resultado.next()) {
               familia = new Familia();
               familia.setId(resultado.getInt(1));
               familia.setNombre(resultado.getString(2));
               familia.setEdad_minima(resultado.getInt(3));
               familia.setEdad_maxima(resultado.getInt(4));
               familia.setNum_hijos(resultado.getInt(5));
               familia.setEmail(resultado.getString(6));
               familia.setCasa_familia(cd.BuscarCasa(resultado.getInt(7)));
               
               familias.add(familia);
            }
            desconectarBase();
            return familias;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
    
    public Collection<Familia> listarFamiliasxEmail(String email) throws Exception{
        try {
            CasaDAO cd = new CasaDAO();
            String sql = "Select id_familia,nombre,edad_minima,edad_maxima,num_hijos,email,id_casa_familia from familias"
                      + " where email like '%"+email+"%'";
            consultarBase(sql);
            Familia familia;
            Collection<Familia> familias = new ArrayList();
            
            while (resultado.next()) {
               familia = new Familia();
               familia.setId(resultado.getInt(1));
               familia.setNombre(resultado.getString(2));
               familia.setEdad_minima(resultado.getInt(3));
               familia.setEdad_maxima(resultado.getInt(4));
               familia.setNum_hijos(resultado.getInt(5));
               familia.setEmail(resultado.getString(6));
               familia.setCasa_familia(cd.BuscarCasa(resultado.getInt(7)));
               
               familias.add(familia);
            }
            desconectarBase();
            return familias;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
}
