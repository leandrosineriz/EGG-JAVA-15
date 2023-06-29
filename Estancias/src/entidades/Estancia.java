/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;


import java.util.Date;

/**
 *
 * @author itsmi
 */
public class Estancia {
    private int id_estancia;
    private Cliente cliente;
    private Casa casa;
    private String nombre_huesped;
    private Date fecha_desde;
    private Date fecha_hasta;

    public Estancia() {
    }

    public Estancia(int id_estancia, Cliente id_cliente, Casa id_casa, String nombre_huesped, Date fecha_desde, 
            Date fecha_hasta) {
        this.id_estancia = id_estancia;
        this.cliente = id_cliente;
        this.casa = id_casa;
        this.nombre_huesped = nombre_huesped;
        this.fecha_desde = fecha_desde;
        this.fecha_hasta = fecha_hasta;
    }

    public Date getFecha_hasta() {
        return fecha_hasta;
    }

    public void setFecha_hasta(Date fecha_hasta) {
        this.fecha_hasta = fecha_hasta;
    }

    public int getId_estancia() {
        return id_estancia;
    }

    public void setId_estancia(int id_estancia) {
        this.id_estancia = id_estancia;
    }

    public Cliente getId_cliente() {
        return cliente;
    }

    public void setId_cliente(Cliente id_cliente) {
        this.cliente = id_cliente;
    }

    public Casa getId_casa() {
        return casa;
    }

    public void setId_casa(Casa id_casa) {
        this.casa = id_casa;
    }

    public String getNombre_huesped() {
        return nombre_huesped;
    }

    public void setNombre_huesped(String nombre_huesped) {
        this.nombre_huesped = nombre_huesped;
    }

    public Date getFecha_desde() {
        return fecha_desde;
    }

    public void setFecha_desde(Date fecha_desde) {
        this.fecha_desde = fecha_desde;
    }

    @Override
    public String toString() {
        return "Estancia{" + "id_estancia=" + id_estancia + ", cliente=" + cliente + ", casa=" + casa + 
                ", nombre_huesped=" + nombre_huesped + ", fecha_desde=" + fecha_desde + ", fecha_hasta=" + 
                fecha_hasta + '}';
    }
    
    
}
