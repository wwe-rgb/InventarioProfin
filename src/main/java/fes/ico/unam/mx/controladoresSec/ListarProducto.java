package fes.ico.unam.mx.controladoresSec;

import fes.ico.unam.mx.clases.ArbolBinarioBusqueda;
import fes.ico.unam.mx.clases.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListarProducto {

    private GestorProductos gestorProductos; // Referencia al gestor singleton de productos.

    @FXML
    private ListView<String> listaProductos; // ListView de JavaFX para mostrar los productos.

    /**
     * Método llamado automáticamente después de que la vista se carga.
     * Inicializa el controlador y actualiza la lista de productos.
     */
    @FXML
    public void initialize() {
        gestorProductos = GestorProductos.obtenerInstancia(); // Obtener instancia única del gestor.
        actualizarLista(); // Cargar y mostrar los productos en la lista.
    }

    /**
     * Actualiza la lista de productos en el ListView.
     * Obtiene los productos almacenados en el árbol en orden y los muestra en formato legible.
     */
    @FXML
    public void actualizarLista() {
        // Obtener los productos en orden usando el árbol binario de búsqueda.
        List<Producto> productosEnOrden = gestorProductos.getArbol().recorrerEnOrden();

        // Crear una lista observable para el ListView.
        ObservableList<String> items = FXCollections.observableArrayList();

        // Convertir los productos a una representación de texto legible.
        for (Producto producto : productosEnOrden) {
            String infoProducto = String.format("ID: %d | Nombre: %s | Precio: $%.2f | Stock: %d",
                    producto.getIdProducto(),       // ID del producto.
                    producto.getProducto(),         // Nombre del producto.
                    producto.getPrecioProducto(),   // Precio del producto.
                    producto.getCantidad());        // Cantidad en stock.
            items.add(infoProducto); // Agregar la representación de texto a la lista.
        }

        // Establecer los elementos en el ListView.
        listaProductos.setItems(items);
    }
}