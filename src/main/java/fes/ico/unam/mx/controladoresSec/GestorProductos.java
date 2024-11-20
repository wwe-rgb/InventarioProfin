package fes.ico.unam.mx.controladoresSec;


import fes.ico.unam.mx.clases.ArbolBinarioBusqueda;
import fes.ico.unam.mx.clases.Producto;

/**
 * Clase singleton que gestiona un inventario de productos utilizando un Árbol Binario de Búsqueda (ABB).
 * Ofrece funcionalidades para agregar, buscar y eliminar productos.
 */
public class GestorProductos {

    private static GestorProductos instancia; // Instancia única de la clase (Singleton).
    private ArbolBinarioBusqueda<Producto> arbol; // Árbol binario de búsqueda para almacenar los productos.

    /**
     * Constructor privado para implementar el patrón Singleton.
     * Inicializa el árbol binario de búsqueda.
     */
    private GestorProductos() {
        arbol = new ArbolBinarioBusqueda<>();
    }

    /**
     * Obtiene la instancia única de la clase. Si no existe, la crea.
     *
     * @return La instancia única de GestorProductos.
     */
    public static GestorProductos obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorProductos();
        }
        return instancia;
    }

    /**
     * Obtiene el árbol binario de búsqueda que almacena los productos.
     *
     * @return El árbol binario de búsqueda de productos.
     */
    public ArbolBinarioBusqueda<Producto> getArbol() {
        return arbol;
    }

    /**
     * Agrega un producto al árbol binario de búsqueda.
     *
     * @param producto El producto a agregar.
     * @return true si el producto se agregó correctamente, false en caso contrario.
     */
    public boolean agregarProducto(Producto producto) {
        if (producto == null || producto.getIdProducto() < 0) {
            // Validación: el producto no puede ser nulo y debe tener un ID válido.
            return false;
        }
        try {
            arbol.insertar(producto); // Insertar el producto en el árbol.
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Manejo de excepciones en caso de error.
        }
    }

    /**
     * Busca un producto en el árbol por su ID.
     *
     * @param id El ID del producto a buscar.
     * @return El producto encontrado, o null si no existe.
     */
    public Producto buscarProducto(int id) {
        if (id < 0) {
            return null; // Validación: el ID debe ser no negativo.
        }
        try {
            // Se crea un producto ficticio con el ID dado para buscar en el árbol.
            return arbol.buscar(new Producto(null, id, 0, 0));
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Manejo de excepciones en caso de error.
        }
    }

    /**
     * Elimina un producto del árbol por su ID.
     *
     * @param id El ID del producto a eliminar.
     * @return true si el producto se eliminó correctamente, false si no existe o ocurre un error.
     */
    public boolean eliminarProducto(int id) {
        if (id < 0) {
            return false; // Validación: el ID debe ser no negativo.
        }
        try {
            // Se crea un producto ficticio con el ID dado para buscar y eliminar.
            Producto productoAEliminar = new Producto(null, id, 0, 0);
            if (arbol.buscar(productoAEliminar) == null) {
                return false; // El producto no existe en el árbol.
            }
            arbol.eliminar(productoAEliminar); // Eliminar el producto del árbol.
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Manejo de excepciones en caso de error.
        }
    }
}