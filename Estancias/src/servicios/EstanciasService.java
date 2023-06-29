/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Casa;
import entidades.Estancia;
import entidades.Familia;
import java.util.Scanner;
import persistencia.CasaDAO;
import persistencia.EstanciaDAO;
import persistencia.FamiliaDAO;

/**
 *
 * @author itsmi
 */
public class EstanciasService {
    FamiliaDAO familiaDao = new FamiliaDAO();
    CasaDAO casaDao= new CasaDAO();
    EstanciaDAO estanciaDao= new EstanciaDAO();
    
    public void menu() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int opc;
        try {
            while (true) {
                System.out.println("\nMENU:");
                System.out.println(
                    "1) Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años.\n" +
                    "2) Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de\n" +
                    "2020 y el 31 de agosto de 2020 en Reino Unido.\n" +
                    "3) Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail.\n" +
                    "4) Consulta la BD para que te devuelva aquellas casas disponibles a partir de una fecha dada\n" +
                    "y un número de días específico.\n" +
                    "5) Listar los datos de todos los clientes que en algún momento realizaron una estancia y la\n" +
                    "descripción de la casa donde la realizaron.\n" +
                    "6) Listar todas las estancias que han sido reservadas por un cliente, mostrar el nombre, país y\n" +
                    "ciudad del cliente y además la información de la casa que reservó. La que reemplazaría a\n" +
                    "la anterior\n" +
                    "7) Debido a la devaluación de la libra esterlina con respecto al euro se desea incrementar el\n" +
                    "precio por día en un 5% de todas las casas del Reino Unido. Mostar los precios\n" +
                    "actualizados.\n" +
                    "8) Obtener el número de casas que existen para cada uno de los países diferentes.\n" +
                    "9) Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios)\n" +
                    "que están ‘limpias’.\n" +
                    "10) Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas.\n" +
                    "Para finalizar, pensar junto con un compañero cómo sería posible optimizar las tablas de la BD\n" +
                    "para tener un mejor rendimiento.");
            
                opc = leer.nextInt();

                switch (opc) {
                    case 1:
                        for (Familia f : familiaDao.listarFamilias(3, 10)) {
                            System.out.println(f);
                        }
                    break;
                    case 2:
                        for (Casa c : casaDao.ListarCasas(FechaAString(2020, 8, 1), FechaAString(2020, 8, 31))) {
                            System.out.println(c);
                        }
                    break;
                    case 3:
                        for (Familia f : familiaDao.listarFamiliasxEmail("hotmail")) {
                            System.out.println(f);
                        }
                    break;
                    case 4:
                        for (Casa c : casaDao.ListarCasas(FechaAString(2020, 06, 01), 100)) {
                            System.out.println(c);
                        }
                    break;
                    case 5:
                        for (Estancia c : estanciaDao.ListarEstancias()) {
                            System.out.println(c);
                        }
                    break;
                    default:
                        System.out.println("Opcion incorrecta.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error Menu.");
        }
        
    }
    
    private String FechaAString(int anio, int mes, int dia) { 
        String prefijoMes = "";
        String prefijoDia = "";
        if (mes<10) {
            prefijoMes = "0";
        }
        if (dia<10) {
            prefijoDia = "0";
        }
        return anio+"-"+prefijoMes+mes+"-"+prefijoDia+dia;
    }
    
}
