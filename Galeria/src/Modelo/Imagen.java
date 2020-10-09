/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class Imagen implements Serializable{
    String ruta;

    public Imagen(String ruta) {
        this.ruta = ruta;
    }

    

    public String getRuta() {
        return ruta;
    }



    @Override
    public String toString() {
        return "Imagen{" + "ruta=" + ruta + '}';
    }
    
    
    
}
