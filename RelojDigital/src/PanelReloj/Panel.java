/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelReloj;

import java.util.Calendar;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import relojdigital.Digito;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class Panel {

    StackPane root;
    Calendar calendario; // objeto calendario con metodos 
    Digito[] digito;

    public Panel() {
        crearPanel();

    }

    public StackPane getRoot() {
        return root;
    }

    public void crearPanel() {
        digito = new Digito[6];
        calendario = Calendar.getInstance();// obtener el tiempo actual del reloj
        // obetener los valores de la hora actual hh:mm:ss
        int horas = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);

        digito[0] = new Digito(horas / 10);
        digito[1] = new Digito(horas % 10);
        digito[2] = new Digito(minutos / 10);
        digito[3] = new Digito(minutos % 10);
        digito[4] = new Digito(segundos / 10);
        digito[5] = new Digito(segundos % 10);
        actualizarReloj();
        ejecutarReloj();
        // contenedor vertical
        VBox[] puntos = new VBox[2]; // array de la clase vbox
        puntos[0] = new VBox();
        puntos[1] = new VBox();
        for (VBox vBox : puntos) {
            vBox.setAlignment(Pos.CENTER);
            vBox.setSpacing(10);
            vBox.getChildren().addAll(
                    new Circle(5, Color.CORAL),
                    new Circle(5, Color.CORAL)
            );

        }
        // contenedor horizonal
        HBox cont = new HBox();
        cont.setAlignment(Pos.CENTER);
        cont.getTransforms().add(new Translate(0, 20));//manipular la posicion
        cont.setSpacing(10);

        cont.getChildren().addAll(
                digito[0], digito[1], puntos[0],
                digito[2], digito[3], puntos[1],
                digito[4], digito[5]);

        root = new StackPane();
        ImageView fondo = new ImageView("imagenes/fondoReloj.png");

        root.getChildren().addAll(fondo, cont);

    }

    public void actualizarReloj() {
        calendario = Calendar.getInstance();// obtener el tiempo actual del reloj
        // obetener los valores de la hora actual hh:mm:ss
        int horas = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);

        digito[0].actualizarNumero(horas / 10);
        digito[1].actualizarNumero(horas % 10);
        digito[2].actualizarNumero(minutos / 10);
        digito[3].actualizarNumero(minutos % 10);
        digito[4].actualizarNumero(segundos / 10);
        digito[5].actualizarNumero(segundos % 10);

    }
    
    public void ejecutarReloj(){ // usar la libreria TimeLine
        Timeline lineaTiempo= new Timeline();
        Timeline lineaSecundaria = new Timeline();
        lineaSecundaria.setCycleCount(Timeline.INDEFINITE);// realiza ciclos infinitos en esa linea de tiempo
        
        KeyFrame keyPrimario = new KeyFrame(          // eventos en la linea de tiempo primaria
        new Duration(1000- calendario.get(Calendar.MILLISECOND)%1000),
                (event)->{
                  actualizarReloj();
                  lineaSecundaria.play();
                }
        );
        // linea secuandaria 
        KeyFrame keySecundario = new KeyFrame(
         Duration.seconds(1),
         (event)->{
            actualizarReloj();
         }   
         
        );
        lineaTiempo.getKeyFrames().add(keyPrimario);
        lineaSecundaria.getKeyFrames().add(keySecundario);
        
        lineaTiempo.play();
    }

}
