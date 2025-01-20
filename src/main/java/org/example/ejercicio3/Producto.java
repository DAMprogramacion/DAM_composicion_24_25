package org.example.ejercicio3;

import java.util.Objects;

public record Producto(int id, String nombreProducto, double precio) {
    //1,gafas de solo,125.20

    @Override
    public String toString() {
        return String.format("%d;%s;%.2f", id, nombreProducto, precio).
                replace(',', '.').replace(';',',');
    }

   /* @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id == producto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }*/
}
