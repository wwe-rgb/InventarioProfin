package fes.ico.unam.mx.controladoresSec;


import fes.ico.unam.mx.clases.ArbolBinarioBusqueda;
import fes.ico.unam.mx.clases.Producto;

public class GestorProductos {
    private static GestorProductos instancia;
    private ArbolBinarioBusqueda<Producto> arbol;

    private GestorProductos() {
        arbol = new ArbolBinarioBusqueda<>();
    }

    public static GestorProductos obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorProductos();
        }
        return instancia;
    }

    public ArbolBinarioBusqueda<Producto> getArbol() {
        return arbol;
    }

    public boolean agregarProducto(Producto producto) {
        if (producto == null || producto.getIdProducto() < 0) {
            return false;
        }
        try {
            arbol.insertar(producto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Producto buscarProducto(int id) {
        if (id < 0) {
            return null;
        }
        try {
            return arbol.buscar(new Producto(null, id, 0, 0));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean eliminarProducto(int id) {
        if (id < 0) {
            return false;
        }
        try {
            Producto productoAEliminar = new Producto(null, id, 0, 0);
            if (arbol.buscar(productoAEliminar) == null) {
                return false; // El producto no existe
            }
            arbol.eliminar(productoAEliminar);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}