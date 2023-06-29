/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Estancia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author itsmi
 */
public class EstanciaDAO extends DAO{
    ClienteDAO clienteDao = new ClienteDAO();
    CasaDAO casaDao = new CasaDAO();
    
    public List<Estancia> ListarEstancias() throws Exception{
        try {
            String sql = "Select id_estancia,id_cliente,id_casa,nombre_huesped,fecha_desde,fecha_hasta from estancias;";
            consultarBase(sql);
            Estancia estancia = null;
            List<Estancia> estancias = new ArrayList();
            
            while (resultado.next()) {
               estancia = new Estancia();
               estancia.setId_estancia(resultado.getInt(1));
               estancia.setId_cliente(clienteDao.BuscarCliente(resultado.getInt(2)));
               estancia.setId_casa(casaDao.BuscarCasa(resultado.getInt(3)));
               estancia.setNombre_huesped(resultado.getString(4));
               estancia.setFecha_desde(resultado.getDate(5));
               estancia.setFecha_hasta(resultado.getDate(6));
               
               estancias.add(estancia);
            }
            
            desconectarBase();
            return estancias;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
}
