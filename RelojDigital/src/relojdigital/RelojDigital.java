/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relojdigital;

import PanelReloj.Panel;
import javafx.application.Application;

import javafx.scene.Scene;

import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class RelojDigital extends Application {

    @Override
    public void start(Stage primaryStage) {

        Panel panel = new Panel();

        Scene scene = new Scene(panel.getRoot());
        primaryStage.setTitle("Reloj Digital");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
