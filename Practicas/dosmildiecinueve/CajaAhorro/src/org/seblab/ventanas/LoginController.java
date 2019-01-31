package org.seblab.ventanas;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private Main stagePrincipal;

    @FXML
    private TextField tfNombre;
    @FXML
    private PasswordField pfContra;
    @FXML
    private Button btnEntrar,btnCancelar;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnEntrar.addActionListener((ActiveEvent)->{
        });
    }

    public void setStagePrincipal(Main main) {
        this.stagePrincipal = stagePrincipal;
    }
}
