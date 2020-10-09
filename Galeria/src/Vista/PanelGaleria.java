/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Imagen;
import java.io.File;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class PanelGaleria {
    BorderPane pane;
    Button btnSubir;
    Button btnEliminar;
    private File fileDirectory,fileSelected;
    static ArrayList<Imagen> listImg;
    private ArrayList<ImageView> listImgv;
    public PanelGaleria() {
        listImg= new ArrayList<>();
        listImgv = new ArrayList<>();
        pane= new BorderPane();
        btnSubir = new Button("Cargar Imagen");
        btnEliminar= new Button("Eliminar");
        init();
    }
    public void init (){
        //cargarGaleria();
        createTop();
        createCenter();
        crearBotton();
        
    }
    
    public void createTop(){
        HBox header= new HBox(20);
        header.setAlignment(Pos.CENTER);
        header.getChildren().add(new Label("GALERIA DE FOTOS"));
        pane.setTop(header);
    
    
    }
    
    
    public void createCenter(){
        cargarGaleria();
        HBox fotos= new HBox(10);
        ScrollPane spane= new ScrollPane(); 
        spane.setCenterShape(true);
        fotos.setAlignment(Pos.CENTER);
        manejarImagen();
        actualizar(fotos); 
        spane.setContent(fotos);
        pane.setCenter(spane);        
    }
    
    public void crearBotton(){
        HBox opciones = new HBox(15);               
        opciones.setAlignment(Pos.CENTER);
        
        opciones.getChildren().addAll(btnSubir,btnEliminar);
        pane.setBottom(opciones);
       
        
        
    }
    
    
    public void actualizar (HBox imagenes){
        imagenes.getChildren().clear();
        listImg.forEach((i) -> {
            ImageView imV= new  ImageView(new Image(i.getRuta(), 150, 200, true, true));
            listImgv.add(imV);
            imagenes.getChildren().add(imV);
        });
        
    }
    public void cargarGaleria(){
        listImg= ManejadorContenidoArchivos.leerObjetosSerializado("imagenes.ser");
                
    }
    
    public void manejarImagen(){
        //cargarGaleria();
        Stage stage = new Stage();
        FileChooser chooser= new FileChooser();
        chooser.setTitle("ArcShivos");
        fileDirectory = new File("./");
        chooser.setInitialDirectory(fileDirectory);
        btnSubir.setOnAction((event) -> {
            fileDirectory = chooser.showOpenDialog(stage);
            fileSelected= fileDirectory.getAbsoluteFile();
            listImg.add(new Imagen(fileSelected.toURI().toString())); 
            ManejadorContenidoArchivos.GuardarObjetoSerializado("imagenes.ser", listImg);
            createCenter();

            
        });
        
        
        //marcarImagen();
        btnEliminar.setOnAction((e) -> {
                System.out.println("eliminar");
                
            }); 
        
        
        
        
        
        
        
        
    }
    
    public void marcarImagen(){
        for (ImageView img : listImgv) {
            System.out.println("for");
            img.setOnMouseClicked((event) -> {
                System.out.println("press");
                
                if (img.isDisable()==true){
                    img.setDisable(false); 
                }else img.setDisable(true); 
                  
            });    
        }  
       
        
    }
    

    public BorderPane getPane() {
        return pane;
    }
    
    
    
    
    
    
    
    
}
