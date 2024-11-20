package fes.ico.unam.mx.clases;


import java.util.ArrayList;
import java.util.List;

/**
 * Clase genérica que implementa un Árbol Binario de Búsqueda (ABB).
 * Permite almacenar elementos genéricos que implementen la interfaz Comparable.
 * Ofrece funcionalidades para insertar, buscar, eliminar y recorrer el árbol en orden.
 *
 * @param <T> El tipo de los elementos almacenados en el árbol. Debe ser comparable.
 */
public class ArbolBinarioBusqueda<T extends Comparable<T> & java.lang.Comparable<T>> {

    private NodoArbolBinario<T> raiz;

    /**
     * Constructor por defecto. Inicializa el árbol vacío.
     */
    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }

    /**
     * Inserta un nuevo valor en el árbol. Si el valor ya existe, no se añade.
     *
     * @param valor El valor a insertar.
     */
    public void insertar(T valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    /**
     * Método recursivo auxiliar para insertar un valor en el árbol.
     *
     * @param nodo  El nodo actual en la recursión.
     * @param valor El valor a insertar.
     * @return El nodo actualizado después de la inserción.
     */
    private NodoArbolBinario<T> insertarRecursivo(NodoArbolBinario<T> nodo, T valor) {
        if (nodo == null) {
            // Si el nodo es null, se crea un nuevo nodo con el valor.
            return new NodoArbolBinario<>(valor);
        }

        // Comparar el valor con el dato actual del nodo.
        if (valor.compareTo(nodo.getData()) == 0) {
            return nodo; // No se permiten duplicados, retornar el nodo sin cambios.
        }
        if (valor.compareTo(nodo.getData()) < 0) {
            // Insertar en el subárbol izquierdo si el valor es menor.
            nodo.setHijoIzquierdo(insertarRecursivo(nodo.getHijoIzquierdo(), valor));
        } else {
            // Insertar en el subárbol derecho si el valor es mayor.
            nodo.setHijoDerecho(insertarRecursivo(nodo.getHijoDerecho(), valor));
        }
        return nodo;
    }

    /**
     * Busca un valor en el árbol.
     *
     * @param valor El valor a buscar.
     * @return El valor encontrado, o null si no está en el árbol.
     */
    public T buscar(T valor) {
        return buscarRecursivo(raiz, valor);
    }

    /**
     * Método recursivo auxiliar para buscar un valor en el árbol.
     *
     * @param nodo  El nodo actual en la recursión.
     * @param valor El valor a buscar.
     * @return El valor encontrado, o null si no se encuentra.
     */
    private T buscarRecursivo(NodoArbolBinario<T> nodo, T valor) {
        if (nodo == null) {
            return null; // Si el nodo es null, el valor no está en el árbol.
        }
        if (valor.compareTo(nodo.getData()) == 0) {
            return nodo.getData(); // Valor encontrado.
        }
        // Buscar en el subárbol izquierdo o derecho según el valor.
        return valor.compareTo(nodo.getData()) < 0
                ? buscarRecursivo(nodo.getHijoIzquierdo(), valor)
                : buscarRecursivo(nodo.getHijoDerecho(), valor);
    }

    /**
     * Recorre el árbol en orden (in-order) y devuelve una lista con los valores.
     *
     * @return Una lista con los valores en orden.
     */
    public List<T> recorrerEnOrden() {
        List<T> resultado = new ArrayList<>();
        recorrerEnOrdenRecursivo(raiz, resultado);
        return resultado;
    }

    /**
     * Método recursivo auxiliar para el recorrido en orden.
     *
     * @param nodo      El nodo actual en la recursión.
     * @param resultado La lista donde se almacenan los valores en orden.
     */
    private void recorrerEnOrdenRecursivo(NodoArbolBinario<T> nodo, List<T> resultado) {
        if (nodo != null) {
            recorrerEnOrdenRecursivo(nodo.getHijoIzquierdo(), resultado);
            resultado.add(nodo.getData());
            recorrerEnOrdenRecursivo(nodo.getHijoDerecho(), resultado);
        }
    }

    /**
     * Elimina un valor del árbol.
     *
     * @param valor El valor a eliminar.
     * @return true si el árbol aún tiene elementos, false si queda vacío.
     */
    public boolean eliminar(T valor) {
        raiz = eliminarRecursivo(raiz, valor);
        return (raiz != null);
    }

    /**
     * Método recursivo auxiliar para eliminar un valor del árbol.
     *
     * @param nodo  El nodo actual en la recursión.
     * @param valor El valor a eliminar.
     * @return El nodo actualizado después de la eliminación.
     */
    private NodoArbolBinario<T> eliminarRecursivo(NodoArbolBinario<T> nodo, T valor) {
        if (nodo == null) {
            return null; // Si el nodo es null, el valor no está en el árbol.
        }

        // Buscar el nodo a eliminar.
        if (valor.compareTo(nodo.getData()) < 0) {
            nodo.setHijoIzquierdo(eliminarRecursivo(nodo.getHijoIzquierdo(), valor));
        } else if (valor.compareTo(nodo.getData()) > 0) {
            nodo.setHijoDerecho(eliminarRecursivo(nodo.getHijoDerecho(), valor));
        } else {
            // Nodo encontrado.
            if (nodo.getHijoIzquierdo() == null) {
                return nodo.getHijoDerecho(); // Si no tiene hijo izquierdo.
            } else if (nodo.getHijoDerecho() == null) {
                return nodo.getHijoIzquierdo(); // Si no tiene hijo derecho.
            }

            // Nodo con dos hijos: encontrar el mínimo en el subárbol derecho.
            T minValue = encontrarMinimo(nodo.getHijoDerecho());
            nodo.setData(minValue);
            nodo.setHijoDerecho(eliminarRecursivo(nodo.getHijoDerecho(), minValue));
        }
        return nodo;
    }

    /**
     * Encuentra el valor mínimo en un subárbol.
     *
     * @param nodo La raíz del subárbol.
     * @return El valor mínimo.
     */
    private T encontrarMinimo(NodoArbolBinario<T> nodo) {
        T minValue = nodo.getData();
        while (nodo.getHijoIzquierdo() != null) {
            nodo = nodo.getHijoIzquierdo();
            minValue = nodo.getData();
        }
        return minValue;
    }
}