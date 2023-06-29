/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author itsmi
 */
public class Familia {
    private int id;
    private String nombre;
    private int edad_minima;
    private int edad_maxima;
    private int num_hijos;
    private String email;
    private Casa casa_familia;

    public Familia() {
    }

    public Familia(int id, String nombre, int edad_minima, int edad_maxima, int num_hijos, String email, 
            Casa casa_familia) {
        this.id = id;
        this.nombre = nombre;
        this.edad_minima = edad_minima;
        this.edad_maxima = edad_maxima;
        this.num_hijos = num_hijos;
        this.email = email;
        this.casa_familia = casa_familia;
    }

    public Casa getCasa_familia() {
        return casa_familia;
    }

    public void setCasa_familia(Casa casa_familia) {
        this.casa_familia = casa_familia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad_minima() {
        return edad_minima;
    }

    public void setEdad_minima(int edad_minima) {
        this.edad_minima = edad_minima;
    }

    public int getEdad_maxima() {
        return edad_maxima;
    }

    public void setEdad_maxima(int edad_maxima) {
        this.edad_maxima = edad_maxima;
    }

    public int getNum_hijos() {
        return num_hijos;
    }

    public void setNum_hijos(int num_hijos) {
        this.num_hijos = num_hijos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Familia{" + "id=" + id + ", nombre=" + nombre + ", edad_minima=" + edad_minima + ", edad_maxima=" 
                + edad_maxima + ", num_hijos=" + num_hijos + ", email=" + email + ", casa_familia=\n" 
                + casa_familia + '}';
    }
    
    
}
