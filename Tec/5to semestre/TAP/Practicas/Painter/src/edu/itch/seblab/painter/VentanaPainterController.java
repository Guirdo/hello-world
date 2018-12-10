/*
 * Hola!
 */
package edu.itch.seblab.painter;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class VentanaPainterController implements Initializable {

    @FXML
    private AnchorPane areaDibujo;

    @FXML
    private RadioButton rbNegro;
    @FXML
    private RadioButton rbVerde;
    @FXML
    private RadioButton rbAzul;
    @FXML
    private RadioButton rbRojo;
    @FXML
    private RadioButton rbChico;
    @FXML
    private RadioButton rbMediano;
    @FXML
    private RadioButton rbGrande;

    @FXML
    private ToggleGroup grupoColor;
    @FXML
    private ToggleGroup grupoTamano;

    @FXML
    private Button undo;
    @FXML
    private Button clear;

    private enum PenSize {
        CHICO(2),
        MEDIANO(4),
        GRANDE(6);

        private final int radio;

        PenSize(int radio) {
            this.radio = radio;
        }

        public int getRadio() {
            return radio;
        }

    };

    private PenSize radio = PenSize.MEDIANO;
    private Paint colorBrocha = Color.BLACK;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rbNegro.setUserData(Color.BLACK);
        rbRojo.setUserData(Color.RED);
        rbAzul.setUserData(Color.BLUE);
        rbVerde.setUserData(Color.GREEN);

        rbChico.setUserData(PenSize.CHICO);
        rbMediano.setUserData(PenSize.MEDIANO);
        rbGrande.setUserData(PenSize.GRANDE);
    }
    
    @FXML
    private void dibujarAreaDibujo(MouseEvent event){
        Circle nuevoCirculo = new Circle(event.getX(),event.getY(),radio.getRadio(),colorBrocha);
        areaDibujo.getChildren().add(nuevoCirculo);
    }

    @FXML
    private void colorGrupoSeleccionado(ActionEvent event) {
        colorBrocha = (Color) grupoColor.getSelectedToggle().getUserData();
        System.out.println("Color grupo");
    }

    @FXML
    private void grupoTamanoSeleccionado(ActionEvent event) {
        radio = (PenSize) grupoTamano.getSelectedToggle().getUserData();
        System.out.println("Tamaño grupo");
    }

    @FXML
    private void undoPresionado(ActionEvent event) {
        int cantidad = areaDibujo.getChildren().size();
        if(cantidad>0){
            areaDibujo.getChildren().remove(cantidad-1);
        }
    }

    @FXML
    private void clearPresionado(ActionEvent event) {
        areaDibujo.getChildren().clear();
    }

}
