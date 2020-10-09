package relojdigital;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public final class Digito extends Parent {

    private final ImageView DIGIT;
    private static final Image ZERO = new Image("imagenes/ZERO.png");
    private static final Image ONE = new Image("imagenes/ONE.png");
    private static final Image TWO = new Image("imagenes/TWO.png");
    private static final Image THREE = new Image("imagenes/THREE.png");
    private static final Image  FOUR = new Image("imagenes/FOUR.png");
    private static final Image FIVE = new Image("imagenes/FIVE.png");
    private static final Image SIX = new Image("imagenes/SIX.png");
    private static final Image SEVEN = new Image("imagenes/SEVEN.png");
    private static final Image EIGHT = new Image("imagenes/EIGHT.png");
    private static final Image NINE = new Image("imagenes/NINE.png");

    public Digito(int numero) {
        DIGIT = new ImageView();
        actualizarNumero(numero);
        getChildren().add(DIGIT);
    }

    public void actualizarNumero(int numero) {
        switch (numero) {
            case 0:
                DIGIT.setImage(ZERO);
                break;
            case 1:
                DIGIT.setImage(ONE);
                break;
            case 2:
                DIGIT.setImage(TWO);
                break;
            case 3:
                DIGIT.setImage(THREE);
                break;
            case 4:
                DIGIT.setImage(FOUR);
                break;
            case 5:
                DIGIT.setImage(FIVE);
                break;
            case 6:
                DIGIT.setImage(SIX);
                break;
            case 7:
                DIGIT.setImage(SEVEN);
                break;
            case 8:
                DIGIT.setImage(EIGHT);
                break;
            case 9:
                DIGIT.setImage(NINE);
                break;

        }

    }

}
