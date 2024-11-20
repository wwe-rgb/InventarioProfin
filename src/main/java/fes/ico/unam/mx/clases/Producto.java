package fes.ico.unam.mx.clases;

import javafx.scene.control.TextField;
import java.util.Objects;

public class Producto implements Comparable<Producto>, java.lang.Comparable<Producto> {

    private String producto;  // Cambié el nombre a minúscula para seguir la convención Java
    private int idProducto;
    private float precioProducto;
    private int cantidad;

    // Constructor vacío por si es necesario
    public Producto() {}

    // Constructor con TextField
    public Producto(TextField producto1) {
        this.producto = producto1.getText();
    }

    // Constructor principal
    public Producto(String producto, int idProducto, float precioProducto, int cantidad) {
        this.producto = producto;
        this.idProducto = idProducto;
        this.precioProducto = precioProducto;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Método compareTo
    @Override
    public int compareTo(Producto o) {
        return Integer.compare(this.idProducto, o.idProducto);
    }

    // Método equals (para comparar objetos por ID)
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Producto producto = (Producto) object;
        return idProducto == producto.idProducto;
    }

    // Método hashCode
    @Override
    public int hashCode() {
        return Objects.hash(idProducto);
    }

    // Método toString
    @Override
    public String toString() {
        return "Producto{" +
                "producto='" + producto + '\'' +
                ", idProducto=" + idProducto +
                ", precioProducto=" + precioProducto +
                ", cantidad=" + cantidad +
                '}';
    }
}
