package fes.ico.unam.mx.interfaz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.print.attribute.standard.Media;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class ControladorPrincipal  {
    


    @FXML
    private TextField btmContra;

    @FXML
    private TextField btmCorreo;



    @FXML
    void iniciarSesion(ActionEvent event) {try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fes/ico/unam/mx/fxml/menu.fxml"));

        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Menu");
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    

}