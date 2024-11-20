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
            // Validar que el campo de búsqueda esté inicializado.
            if (campoBusqueda == null) {
                mostrarAlerta("Error", "Error de inicialización en la interfaz", Alert.AlertType.ERROR);
                return;
            }

            // Obtener el texto ingresado por el usuario.
            String textoBusqueda = campoBusqueda.getText();

            // Validar que el campo de texto no esté vacío.
            if (textoBusqueda == null || textoBusqueda.trim().isEmpty()) {
                mostrarAlerta("Error", "Debe ingresar el ID del producto para eliminar.", Alert.AlertType.ERROR);
                return;
            }

            try {
                // Convertir el texto ingresado a un número entero.
                int idProducto = Integer.parseInt(textoBusqueda.trim());

                // Obtener la instancia única del gestor de productos.
                GestorProductos gestor = GestorProductos.obtenerInstancia();

                // Buscar el producto con el ID proporcionado.
                Producto productoAEliminar = gestor.buscarProducto(idProducto);

                if (productoAEliminar != null) {
                    // Si el producto existe, obtener su representación como texto.
                    String infoProducto = productoAEliminar.toString();

                    // Eliminar el producto del sistema.
                    gestor.eliminarProducto(idProducto);

                    // Mostrar un mensaje de éxito al usuario.
                    mostrarAlerta("Éxito", "El producto ha sido eliminado correctamente.", Alert.AlertType.INFORMATION);

                    // Actualizar la interfaz para reflejar la operación.
                    resultadoOperacion.setText("Producto eliminado: " + infoProducto);

                    // Limpiar el campo de texto para futuras operaciones.
                    campoBusqueda.clear();
                } else {
                    // Si no se encuentra el producto, informar al usuario.
                    mostrarAlerta("No Encontrado", "No se encontró ningún producto con el ID: " + idProducto, Alert.AlertType.WARNING);
                    resultadoOperacion.setText("Producto no encontrado.");
                }
            } catch (NumberFormatException e) {
                // Manejar el caso donde el ID ingresado no sea un número entero válido.
                mostrarAlerta("Error", "Por favor ingrese un ID válido (número entero).", Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            // Manejar cualquier error inesperado.
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