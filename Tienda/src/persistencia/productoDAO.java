/*
 a) Lista el nombre de todos los productos que hay en la tabla producto.
b) Lista los nombres y los precios de todos los productos de la tabla producto.
"c) Listar aquellos productos que su precio esté entre 120 y 202.

 */
package persistencia;

import entidades.Producto;
import java.util.ArrayList;
import java.util.Collection;

import java.util.List;

/**
 *
 * @author tinap
 */
public final class productoDAO extends DAO{

    public Collection<Producto> listarProductos() throws Exception{
        try {
            String sql = "Select * from producto";
            consultarBase(sql);
            Producto prod = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
               prod = new Producto();
               prod.setCodigo(resultado.getInt(1));
               prod.setNombre(resultado.getString("nombre"));
               prod.setPrecio(resultado.getDouble("precio"));
               prod.setCodigoFabricante(resultado.getInt(4));
               productos.add(prod);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
   
    public List<Producto> listarxPrecios(int a, int b) throws Exception{
        try {
            String sql = "Select * from producto where precio between " + a + " and " + b + " order by precio";
            consultarBase(sql);
            Producto prod = null;
            List<Producto> productos = new ArrayList();
            while (resultado.next()) {
               prod = new Producto();
               prod.setCodigo(resultado.getInt(1));
               prod.setNombre(resultado.getString("nombre"));
               prod.setPrecio(resultado.getDouble("precio"));
               prod.setCodigoFabricante(resultado.getInt(4));
               
               productos.add(prod);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
        
        
    }
    public Collection<Producto> listarPortatiles() throws Exception{
        try {
            String sql = "Select * from producto where nombre like 'portatil%'";
            consultarBase(sql);
            Producto prod = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
               prod = new Producto();
               prod.setCodigo(resultado.getInt(1));
               prod.setNombre(resultado.getString("nombre"));
               prod.setPrecio(resultado.getDouble("precio"));
               prod.setCodigoFabricante(resultado.getInt(4));
               productos.add(prod);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    } 
    
    public Producto listarProductoMasBarato() throws Exception{
        try {
            String sql = "Select * from producto order by precio asc limit 1";
            consultarBase(sql);
            Producto prod = null;
            
            while (resultado.next()) {
               prod = new Producto();
               prod.setCodigo(resultado.getInt(1));
               prod.setNombre(resultado.getString("nombre"));
               prod.setPrecio(resultado.getDouble("precio"));
               prod.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            return prod;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    } 
    
    public void IngresarProducto(Producto p) throws Exception{
        try {
            String sql = "Insert into producto values("+0+",'"+p.getNombre()+"',"+p.getPrecio()+","
                    +p.getCodigoFabricante()+");";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        }
    } 
    
    public void IngresarFabricante(String nombre) throws Exception {
        try {
            String sql = "Insert into fabricante values("+0+",'"+nombre+"');";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        }
    }
    
    public void modificarProducto(Producto p) throws Exception {
        try {
            String sql = "UPDATE producto SET nombre='"+p.getNombre()+"', precio="+p.getPrecio()+
                    ", codigo_fabricante="+p.getCodigoFabricante()+ " WHERE codigo = "+p.getCodigo()+";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        }
    }
}
