/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias;

import servicios.EstanciasService;

/**
 *
 * @author itsmi
 */
public class Estancias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EstanciasService es = new EstanciasService();
        
        es.menu();
    }
    
}
