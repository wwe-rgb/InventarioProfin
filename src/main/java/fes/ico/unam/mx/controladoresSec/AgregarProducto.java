package fes.ico.unam.mx.controladoresSec;

import fes.ico.unam.mx.clases.ArbolBinarioBusqueda;
import fes.ico.unam.mx.clases.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AgregarProducto {

    @FXML
    private TextField Producto1;  // nombre
    @FXML
    private TextField Producto2;  // ID
    @FXML
    private TextField Producto3;  // precio
    @FXML
    private TextField Producto4;  // cantidad

    @FXML
    void agregarProductos(ActionEvent event) {
        try {
            // Obtener y validar los valores
            String nombre = Producto1.getText();
            int idProducto = Integer.parseInt(Producto2.getText());
            float precioProducto = Float.parseFloat(Producto3.getText());
            int cantidadProducto = Integer.parseInt(Producto4.getText());

            if (!nombre.isEmpty() && idProducto > 0 && precioProducto > 0 && cantidadProducto > 0) {
                // Crear el producto y agregarlo usando el gestor
                Producto producto = new Producto(nombre, idProducto, precioProducto, cantidadProducto);
                GestorProductos.obtenerInstancia().agregarProducto(producto);

                // Limpiar los campos
                limpiarCampos();

                // Mostrar mensaje de éxito
                mostrarAlerta("Producto Agregado", "El producto ha sido agregado correctamente.", Alert.AlertType.INFORMATION);
            } else {
                mostrarAlerta("Error", "Por favor, llena todos los campos correctamente.", Alert.AlertType.ERROR);
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "ID, precio y cantidad deben ser números válidos.", Alert.AlertType.ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error", "Ocurrió un error al agregar el producto: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
//Muestra los productos agregados
    @FXML
    void mostrarProductos(ActionEvent event) {
        try {
            String productos = GestorProductos.obtenerInstancia().getArbol().recorrerEnOrden().toString();
            mostrarAlerta("Productos en el Árbol", productos, Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error", "Error al mostrar los productos: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
//Limpia los campos antes de volver a meter valores
    private void limpiarCampos() {
        Producto1.clear();
        Producto2.clear();
        Producto3.clear();
        Producto4.clear();
    }
    //Muestra la alerta de los productos agregados

    private void mostrarAlerta(String titulo, String contenido, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}