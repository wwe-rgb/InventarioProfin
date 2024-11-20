package fes.ico.unam.mx.interfaz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu {
    @FXML
    void agregarProducto(ActionEvent event) {try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fes/ico/unam/mx/fxml/agregarProducto.fxml"));

        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Agregar Producto");
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    @FXML
    void buscarProducto(ActionEvent event) {try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fes/ico/unam/mx/fxml/buscarProducto.fxml"));

        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Buscar producto");
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    @FXML
    void eiminarProducto(ActionEvent event) {try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fes/ico/unam/mx/fxml/eliminarProducto.fxml"));

        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Eliminar Producto");
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    @FXML
    void listarProductos(ActionEvent event) {try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fes/ico/unam/mx/fxml/listarProducto.fxml"));

        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Listar productos");
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

}


