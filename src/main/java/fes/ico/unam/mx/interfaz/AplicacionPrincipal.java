package fes.ico.unam.mx.interfaz;

import fes.ico.unam.mx.clases.ArbolBinarioBusqueda;
import fes.ico.unam.mx.clases.Producto;
import fes.ico.unam.mx.controladoresSec.BuscarProducto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AplicacionPrincipal extends Application {
    private static ArbolBinarioBusqueda<Producto> busquedaBinario;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AplicacionPrincipal.class.getResource("/fes/ico/unam/mx/fxml/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Inicio");
        stage.setScene(scene);
        stage.show();

    }


    public static void main(String[] args) {
        launch();
    }
}