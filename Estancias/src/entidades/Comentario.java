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
public class Comentario {
    private int id_comentario; 
    private Casa casa; 
    private String comentario;

    public Comentario() {
    }

    public Comentario(int id_comentario, Casa id_casa, String comentario) {
        this.id_comentario = id_comentario;
        this.casa = id_casa;
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }

    public Casa getId_casa() {
        return casa;
    }

    public void setId_casa(Casa id_casa) {
        this.casa = id_casa;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id_comentario=" + id_comentario + ", casa=" + casa + ", comentario=" + comentario + '}';
    }
    
    
}
