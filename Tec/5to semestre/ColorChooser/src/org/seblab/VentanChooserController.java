/*
 * Hola!
 */
package org.seblab;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class VentanChooserController implements Initializable {
    
    @FXML private Slider sliderRojo;
    @FXML private Slider sliderVerde;
    @FXML private Slider sliderAzul;
    @FXML private Slider sliderAlfa;
    @FXML private TextField tfRojo;
    @FXML private TextField tfVerde;
    @FXML private TextField tfAzul;
    @FXML private TextField tfAlfa;
    @FXML private Rectangle recColor;
    
    private int rojo = 0;
    private int verde = 0;
    private int azul = 0;
    private double alfa = 1.0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        recColor.setFill(Color.rgb(rojo, verde, azul, alfa));
        
        tfRojo.textProperty().bind(sliderRojo.valueProperty().asString("%.0f"));
        tfVerde.textProperty().bind(sliderVerde.valueProperty().asString("%.0f"));
        tfAzul.textProperty().bind(sliderAzul.valueProperty().asString("%.0f"));
        tfAlfa.textProperty().bind(sliderAlfa.valueProperty().asString("%.2f"));
        
        sliderRojo.valueProperty().addListener((ov,oldValue,newValue)->{
            rojo = newValue.intValue();
            recColor.setFill(Color.rgb(rojo, verde, azul, alfa));
        });
        
        sliderVerde.valueProperty().addListener((ov,oldValue,newValue)->{
            verde = newValue.intValue();
            recColor.setFill(Color.rgb(rojo, verde, azul, alfa));
        });
        
        sliderAzul.valueProperty().addListener((ov,oldValue,newValue)->{
            azul = newValue.intValue();
            recColor.setFill(Color.rgb(rojo, verde, azul, alfa));
        });
        
        sliderAlfa.valueProperty().addListener((ov,oldValue,newValue)->{
            alfa = newValue.doubleValue();
            recColor.setFill(Color.rgb(rojo, verde, azul, alfa));
        });
    }    
    
}
