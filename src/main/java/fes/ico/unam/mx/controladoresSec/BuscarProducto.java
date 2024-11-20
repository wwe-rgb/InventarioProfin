package fes.ico.unam.mx.controladoresSec;

import fes.ico.unam.mx.clases.ArbolBinarioBusqueda;
import fes.ico.unam.mx.clases.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class BuscarProducto {
    private GestorProductos gestorProductos;

    @FXML
    private TextField Buscar;

    @FXML
    private TextField Resultado;

    @FXML
    public void initialize() {
        // Obtener la instancia del gestor de productos
        gestorProductos = GestorProductos.obtenerInstancia();
    }

    @FXML
    void Buscar(ActionEvent event) {
        try {
            String texto = Buscar.getText();
            if (texto.isEmpty()) {
                mostrarAlerta("Error: Debe ingresar un ID para buscar.");
                return;
            }

            try {
                int id = Integer.parseInt(texto);
                Producto producto = gestorProductos.buscarProducto(id);

                if (producto != null) {
                    Resultado.setText(producto.toString());
                } else {
                    Resultado.setText("No se encontró ningún producto con el ID: " + id);
                }
            } catch (NumberFormatException e) {
                mostrarAlerta("Error: El ID debe ser un número válido.");
                Resultado.setText("");
            }

        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Ocurrió un error al realizar la búsqueda.");
            Resultado.setText("");
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}