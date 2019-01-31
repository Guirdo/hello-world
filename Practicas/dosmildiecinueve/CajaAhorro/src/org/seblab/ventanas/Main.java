package org.seblab.ventanas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage stagePrincipal;
    private Parent rootPane;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.stagePrincipal=primaryStage;
        mostrarLogin();
    }


    public void mostrarLogin(){
        try {
            rootPane = FXMLLoader.load(getClass().getResource("login.fxml"));
            stagePrincipal.setTitle("Login");
            stagePrincipal.setScene(new Scene(rootPane));

            stagePrincipal.show();
            stagePrincipal.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void mostrarMenu(){

    }
    public static void main(String[] args) {
        launch(args);
    }
}
