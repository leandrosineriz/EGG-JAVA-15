/*
 Realizar un menú en Java a través del cual se permita elegir qué consulta se desea realizar.
Las consultas a realizar sobre la BD son las siguientes:
a) Lista el nombre de todos los productos que hay en la tabla producto.
b) Lista los nombres y los precios de todos los productos de la tabla producto.
c) Listar aquellos productos que su precio esté entre 120 y 202.
d) Buscar y listar todos los Portátiles de la tabla producto.
e) Listar el nombre y el precio del producto más barato.
f) Ingresar un producto a la base de datos.
g) Ingresar un fabricante a la base de datos
h) Editar un producto con datos a elección.
 */
package servicios;

import entidades.Producto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import persistencia.productoDAO;

/**
 *
 * @author tinap
 */
public class ProductoService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    productoDAO product = new productoDAO();

    public static void showMenu() {
        System.out.println("===============");
        System.out.println("     MENU      ");
        System.out.println("===============");
        System.out.println("");
        System.out.println("a) Lista el nombre de todos los productos que hay en la tabla producto.\n"
                + "b) Lista los nombres y los precios de todos los productos de la tabla producto.\n"
                + "c) Listar aquellos productos que su precio esté entre 120 y 202.\n"
                + "d) Buscar y listar todos los Portátiles de la tabla producto.\n"
                + "e) Listar el nombre y el precio del producto más barato.\n"
                + "f) Ingresar un producto a la base de datos.\n"
                + "g) Ingresar un fabricante a la base de datos\n"
                + "h) Editar un producto con datos a elección.");

        System.out.println("i)Salir");
        System.out.println("");
        System.out.println("Ingrese un valor y luego presione la tecla enter.");
    }

    public  void menu() throws Exception {
        Scanner leer = new Scanner(System.in);
        String choice;
        do {
            showMenu();
            choice = leer.next();

            switch (choice) {
                case "a":
                   
                    //Collection <Producto> listado = product.listarProductos();
                   
                    for (Producto aux : product.listarProductos()) {
                        System.out.println(aux.getNombre());
                    }
                   ;
                    break;
                case "b":
                    for (Producto aux : product.listarProductos()) {
                        System.out.println(aux.getNombre()+ " " + aux.getPrecio());
                    }
                    break;
                case "c":
                    for (Producto aux : product.listarxPrecios(120, 202)) {
                        System.out.println(aux);
                    }
                    break;
                case "d":
                   for (Producto aux : product.listarPortatiles()) {
                        System.out.println(aux);
                    }
                    break;
                case "e":
                   //Listar el nombre y el precio del producto más barato.
                    Producto prod = product.listarProductoMasBarato();
                    System.out.println(prod.getNombre()+" - "+prod.getPrecio());
                    break;
                case "f":
                    //Ingresar un producto a la base de datos.
                    product.IngresarProducto(this.crearProducto());
                    break;
                case "g":
                    product.IngresarFabricante(this.crearFabricante());
                    break;
                case "h":
                    //Editar un producto con datos a elección.
                    product.modificarProducto(this.ModificarProducto());
                    break;
                case "i":
                    System.out.println("Gracias por utilizar el programa!");
                    break;
                default:
                    System.out.println("Digito invalido");

            }
        } while (!choice.equalsIgnoreCase("i"));

    }
    
    private Producto crearProducto(){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el nombre del producto:");
        String nombre = leer.next();
        System.out.println("Ingrese el precio:");
        double precio = leer.nextDouble();
        System.out.println("Ingrese el codigo de fabricante:");
        int codigoFab= leer.nextInt();
        
        return new Producto(0,nombre,precio,codigoFab);
    }
    
    private Producto crearProducto(int codigo){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("\nINGRESE LOS NUEVOS DATOS DEL PRODUCTO:");
        System.out.println("Ingrese el nombre del producto:");
        String nombre = leer.next();
        System.out.println("Ingrese el precio:");
        double precio = leer.nextDouble();
        System.out.println("Ingrese el codigo de fabricante:");
        int codigoFab= leer.nextInt();
        
        return new Producto(codigo,nombre,precio,codigoFab);
    }
    
    private String crearFabricante(){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el nombre del fabricante:");
        String nombre = leer.next();
        
        return nombre;
    }
    
    private Producto ModificarProducto(){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int opc;
        Producto prod = null;
        try {
            for (Producto aux : product.listarProductos()) {
                        System.out.println(aux);
            }
            System.out.println("\nIngrese el codigo del producto a modificar:");
            opc = leer.nextInt();
            prod = this.crearProducto(opc);
        } catch (Exception e) {
            System.out.println("Error sp");
        }
        return prod;
    }
}


