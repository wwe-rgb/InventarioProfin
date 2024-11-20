package fes.ico.unam.mx.clases;


import java.util.ArrayList;
import java.util.List;

public class ArbolBinarioBusqueda<T extends Comparable<T> & java.lang.Comparable<T>> {

    private NodoArbolBinario<T> raiz;

    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }

    public void insertar(T valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private NodoArbolBinario<T> insertarRecursivo(NodoArbolBinario<T> nodo, T valor) {
        if (nodo == null) {
            return new NodoArbolBinario<>(valor);
        }
        if (valor.compareTo(nodo.getData()) == 0) return nodo; // No duplicados
        if (valor.compareTo(nodo.getData()) < 0) {
            nodo.setHijoIzquierdo(insertarRecursivo(nodo.getHijoIzquierdo(), valor));
        } else {
            nodo.setHijoDerecho(insertarRecursivo(nodo.getHijoDerecho(), valor));
        }
        return nodo;
    }

    public T buscar(T valor) {
        return buscarRecursivo(raiz, valor);
    }

    private T buscarRecursivo(NodoArbolBinario<T> nodo, T valor) {
        if (nodo == null) {
            return null; // Producto no encontrado
        }
        if (valor.compareTo(nodo.getData()) == 0) {
            return nodo.getData(); // Producto encontrado
        }
        return valor.compareTo(nodo.getData()) < 0
                ? buscarRecursivo(nodo.getHijoIzquierdo(), valor)
                : buscarRecursivo(nodo.getHijoDerecho(), valor);
    }

    public List<T> recorrerEnOrden() {
        List<T> resultado = new ArrayList<>();
        recorrerEnOrdenRecursivo(raiz, resultado);
        return resultado;
    }

    private void recorrerEnOrdenRecursivo(NodoArbolBinario<T> nodo, List<T> resultado) {
        if (nodo != null) {
            recorrerEnOrdenRecursivo(nodo.getHijoIzquierdo(), resultado);
            resultado.add(nodo.getData());
            recorrerEnOrdenRecursivo(nodo.getHijoDerecho(), resultado);
        }
    }

    public boolean eliminar(T valor) {
        raiz = eliminarRecursivo(raiz, valor);
        return (raiz != null);
    }

    private NodoArbolBinario<T> eliminarRecursivo(NodoArbolBinario<T> nodo, T valor) {
        if (nodo == null) {
            return null;
        }

        if (valor.compareTo(nodo.getData()) < 0) {
            nodo.setHijoIzquierdo(eliminarRecursivo(nodo.getHijoIzquierdo(), valor));
        } else if (valor.compareTo(nodo.getData()) > 0) {
            nodo.setHijoDerecho(eliminarRecursivo(nodo.getHijoDerecho(), valor));
        } else {
            // Nodo encontrado
            if (nodo.getHijoIzquierdo() == null) {
                return nodo.getHijoDerecho();
            } else if (nodo.getHijoDerecho() == null) {
                return nodo.getHijoIzquierdo();
            }

            T minValue = encontrarMinimo(nodo.getHijoDerecho());
            nodo.setData(minValue);
            nodo.setHijoDerecho(eliminarRecursivo(nodo.getHijoDerecho(), minValue));
        }
        return nodo;
    }

    private T encontrarMinimo(NodoArbolBinario<T> nodo) {
        T minValue = nodo.getData();
        while (nodo.getHijoIzquierdo() != null) {
            nodo = nodo.getHijoIzquierdo();
            minValue = nodo.getData();
        }
        return minValue;
    }
}