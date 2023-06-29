/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import entidades.Producto;
import java.util.ArrayList;
/**
 *
 * @author itsmi
 */
public class ProductoDao extends DAO {
    
    public List<Producto> BuscarProductosTodos() throws Exception {
        List<Producto> productos = new ArrayList();
        
        try {
            String sql = "select * from producto;";
            consultarBase(sql);
            while (resultado.next()) {                
               
            }
        } catch (Exception e) {
            throw e;
        }
        return productos;
    }
}
