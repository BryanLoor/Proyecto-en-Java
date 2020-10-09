/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Vista.PanelGaleria;
import javafx.application.Application;

import javafx.scene.Scene;

import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class Galeria extends Application {
    @Override
    public void start(Stage primaryStage) {
        
        
     
        PanelGaleria root = new PanelGaleria();
        Scene scene = new Scene(root.getPane(), 750, 450);
        
        primaryStage.setTitle("Galeria de Fotos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
