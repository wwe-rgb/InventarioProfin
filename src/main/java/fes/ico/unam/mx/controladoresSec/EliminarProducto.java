package fes.ico.unam.mx.controladoresSec;

import fes.ico.unam.mx.clases.ArbolBinarioBusqueda;
import fes.ico.unam.mx.clases.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class EliminarProducto implements Initializable {

        @FXML
        private TextField campoBusqueda;  // Cambiado para coincidir con el FXML

        @FXML
        private Label resultadoOperacion;  // También actualizado para coincidir con el FXML

        @Override
        public void initialize(URL url, ResourceBundle rb) {
            assert campoBusqueda != null : "fx:id=\"campoBusqueda\" no fue inyectado: revisa tu archivo FXML";
        }

        @FXML
        void eliminarProducto(ActionEvent event) {
            try {
                if (campoBusqueda == null) {
                    mostrarAlerta("Error", "Error de inicialización en la interfaz", Alert.AlertType.ERROR);
                    return;
                }

                String textoBusqueda = campoBusqueda.getText();
                if (textoBusqueda == null || textoBusqueda.trim().isEmpty()) {
                    mostrarAlerta("Error", "Debe ingresar el ID del producto para eliminar.", Alert.AlertType.ERROR);
                    return;
                }

                try {
                    int idProducto = Integer.parseInt(textoBusqueda.trim());

                    GestorProductos gestor = GestorProductos.obtenerInstancia();
                    Producto productoAEliminar = gestor.buscarProducto(idProducto);

                    if (productoAEliminar != null) {
                        String infoProducto = productoAEliminar.toString();

                        gestor.eliminarProducto(idProducto);

                        mostrarAlerta("Éxito", "El producto ha sido eliminado correctamente.", Alert.AlertType.INFORMATION);
                        resultadoOperacion.setText("Producto eliminado: " + infoProducto);
                        campoBusqueda.clear();
                    } else {
                        mostrarAlerta("No Encontrado", "No se encontró ningún producto con el ID: " + idProducto, Alert.AlertType.WARNING);
                        resultadoOperacion.setText("Producto no encontrado.");
                    }
                } catch (NumberFormatException e) {
                    mostrarAlerta("Error", "Por favor ingrese un ID válido (número entero).", Alert.AlertType.ERROR);
                }
            } catch (Exception e) {
                e.printStackTrace();
                mostrarAlerta("Error", "Ocurrió un error inesperado: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        }

        private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
            Alert alerta = new Alert(tipo);
            alerta.setTitle(titulo);
            alerta.setHeaderText(null);
            alerta.setContentText(mensaje);
            alerta.showAndWait();
        }
    }