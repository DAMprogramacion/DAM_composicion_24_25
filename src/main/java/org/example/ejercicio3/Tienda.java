package org.example.ejercicio3;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Float.NaN;

public class Tienda {
    private String nombreTienda; //añadido al UML
    private List<Producto> productos = new ArrayList<>();
    //modificación sobre el UML, hay que inicializar el nombre de la tienda

    public Tienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }
    public void addProducto (Producto producto) {
        productos.add(producto);
    }

    public String getNombreTienda() {  //añadido al UML
        return nombreTienda;
    }

    public List<Producto> getProductos() {
        return productos;
    }
    public void eliminarProducto (Producto item){
        //productos.remove(producto); funciona si está sobreescrito equals y hashcode
        for (Producto producto : productos){
            if (producto.id() == item.id()){
                productos.remove(producto);
                //break; funciona, sale del bucle y acaba el metodo
                return;  //directamente sale del bucle
            }
        }
    }
    public Producto obtenerProductoMasCaro() {
        if (productos.isEmpty())
            return null;
        Producto productoMasCaro = productos.get(0);
        for (int i = 1; i < productos.size(); i++)
            if (productos.get(i).precio() >= productoMasCaro.precio()  )
                productoMasCaro = productos.get(i);
        return productoMasCaro;
    }
    public Producto obtenerProductoMasBarato() {
        if (productos.isEmpty())
            return null;
        Producto productoMasBarato = productos.get(0);
        for (int i = 1; i < productos.size(); i++)
            if (productos.get(i).precio() <= productoMasBarato.precio())
                productoMasBarato = productos.get(i);
        return productoMasBarato;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String titulo = String.format("%5s%20s%10s","ID", "PRODUCTO", "PRECIO");
        builder.append(titulo).append('\n');
        for (Producto producto: productos){
            String fila = String.format("%5d%20s%10.2f",
                    producto.id(), producto.nombreProducto(), producto.precio())
                        .replace(',','.');
            builder.append(fila).append('\n');
        }
        builder.append('\n');
        builder.append("TOTAL PRODUCTOS: ").append(productos.size()).append('\n');
        builder.append("MEDIA DE LOS PRECIOS:   ");
        String precioMedioTotalFormateado = String.format("%.2f",
                getprecioMedioTotalFormateado());
        builder.append(precioMedioTotalFormateado).append(" EUROS");
        return builder.toString();
    }

    private double getprecioMedioTotalFormateado() {
        if (productos.isEmpty())
            return 0;
        double suma = 0;
        for (Producto producto : productos)
            suma += producto.precio();
        return suma / productos.size();
    }
}






