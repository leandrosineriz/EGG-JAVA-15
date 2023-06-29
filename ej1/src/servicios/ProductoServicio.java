/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.Scanner;

/**
 *
 * @author itsmi
 */
public class ProductoServicio {
    
    public void menu() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int opc = 0;
        while (true) {            
            System.out.println( "1) Lista el nombre de todos los productos que hay en la tabla producto.\n" +
                                "2) Lista los nombres y los precios de todos los productos de la tabla producto.\n" +
                                "3) Listar aquellos productos que su precio esté entre 120 y 202.\n" +
                                "4) Buscar y listar todos los Portátiles de la tabla producto.\n" +
                                "5) Listar el nombre y el precio del producto más barato.\n" +
                                "6) Ingresar un producto a la base de datos.\n" +
                                "7) Ingresar un fabricante a la base de datos\n" +
                                "8) Editar un producto con datos a elección.");
            try {
                opc = leer.nextInt();
            } catch (Exception e) {
                System.out.println("Ingrese un numero");
                continue;
            }
            switch (opc) {
                case 1:
                    
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        }
    }
}
