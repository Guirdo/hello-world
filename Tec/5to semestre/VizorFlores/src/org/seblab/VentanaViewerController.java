/*
 * Hola!
 */
package org.seblab;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import org.seblab.beans.Flower;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class VentanaViewerController implements Initializable {
    
    @FXML private ListView<Flower> listaFlores;
    @FXML private ImageView imagenFlor;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
