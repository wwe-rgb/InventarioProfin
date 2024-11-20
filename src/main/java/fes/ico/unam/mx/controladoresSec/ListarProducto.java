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
    private GestorProductos gestorProductos;

    @FXML
    private ListView<String> listaProductos;

    @FXML
    public void initialize() {
        gestorProductos = GestorProductos.obtenerInstancia();
        actualizarLista();
    }

    @FXML
    public void actualizarLista() {
        // Obtener la lista en orden del árbol usando el método ya implementado
        List<Producto> productosEnOrden = gestorProductos.getArbol().recorrerEnOrden();

        // Convertir los productos a formato de visualización
        ObservableList<String> items = FXCollections.observableArrayList();

        for (Producto producto : productosEnOrden) {
            String infoProducto = String.format("ID: %d | Nombre: %s | Precio: $%.2f | Stock: %d",
                    producto.getIdProducto(),
                    producto.getProducto(),
                    producto.getPrecioProducto(),
                    producto.getCantidad());
            items.add(infoProducto);
        }

        listaProductos.setItems(items);
    }
}