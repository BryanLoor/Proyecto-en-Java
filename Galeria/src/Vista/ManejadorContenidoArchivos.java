/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Imagen;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class ManejadorContenidoArchivos {
    
    
    /*Nuevos Metodos*/
    public static void GuardarObjetoSerializado(String filename, ArrayList<Imagen> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            
            oos.writeObject(list);

        } catch (IOException ex) {
            System.out.println(ex.getMessage()+"no se puede");
        }

    }

    public static ArrayList<Imagen> leerObjetosSerializado(String filename) {
        ArrayList<Imagen> result = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {

            result = (ArrayList<Imagen>) ois.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
           
        }

        return result;
    }
    
}
