package fes.ico.unam.mx.clases;

import java.lang.Comparable;
import java.util.Objects;

public class NodoArbolBinario<T extends Comparable<T>> implements Comparable<NodoArbolBinario<T>> {
private T data;
private NodoArbolBinario<T> hijoIzquierdo;
private NodoArbolBinario<T> hijoDerecho;

public NodoArbolBinario() {
}

public NodoArbolBinario(T data) {
    this.data = data;
}

public NodoArbolBinario(T data, NodoArbolBinario<T> hijoIzquierdo, NodoArbolBinario<T> hijoDerecho) {
    this.data = data;
    this.hijoIzquierdo = hijoIzquierdo;
    this.hijoDerecho = hijoDerecho;
}

public T getData() {
    return data;
}

public void setData(T data) {
    this.data = data;
}

public NodoArbolBinario<T> getHijoIzquierdo() {
    return hijoIzquierdo;
}

public void setHijoIzquierdo(NodoArbolBinario<T> hijoIzquierdo) {
    this.hijoIzquierdo = hijoIzquierdo;
}

public NodoArbolBinario<T> getHijoDerecho() {
    return hijoDerecho;
}

public void setHijoDerecho(NodoArbolBinario<T> hijoDerecho) {
    this.hijoDerecho = hijoDerecho;
}

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    NodoArbolBinario<?> that = (NodoArbolBinario<?>) o;
    return Objects.equals(data, that.data) && Objects.equals(hijoIzquierdo, that.hijoIzquierdo) && Objects.equals(hijoDerecho, that.hijoDerecho);
}

@Override
public int hashCode() {
    return Objects.hash(data, hijoIzquierdo, hijoDerecho);
}


@Override
public int compareTo(NodoArbolBinario<T> o) {
    return this.data.compareTo(o.getData());
    //return emp1.compareTo(o.getData());
}

@Override
public String toString() {
    return "[-->" + data +
            ", hizq=" + hijoIzquierdo +
            ", hder=" + hijoDerecho +
            "<--]\n";
}
}
