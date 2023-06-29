/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Cliente;

/**
 *
 * @author itsmi
 */
public class ClienteDAO extends DAO{
    
    public Cliente BuscarCliente(int id_cliente) throws Exception{
        try {
            String sql = "Select id_cliente,nombre,calle,numero,codigo_postal,ciudad,pais,email from clientes "
                    + "where id_cliente="+id_cliente+";";
            consultarBase(sql);
            Cliente cliente = null;
            
            while (resultado.next()) {
               cliente = new Cliente();
               
               cliente.setId_cliente(resultado.getInt(1));
               cliente.setNombre(resultado.getString(2));
               cliente.setCalle(resultado.getString(3));
               cliente.setNumero(resultado.getInt(4));
               cliente.setCodigo_postal(resultado.getString(5));
               cliente.setCiudad(resultado.getString(6));
               cliente.setPais(resultado.getString(7));
               cliente.setEmail(resultado.getString(8));
            }
            
            desconectarBase();
            return cliente;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
}
