package org.example.ejercicio3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestTienda {
    public static void main(String[] args) {
        Producto[] productos = {new Producto(1, "gafas", 52.3),
            new Producto(2, "crema solar", 22.22),
            new Producto(3, "sombrilla", 50.22),
            new Producto(4, "toalla baño", 32.22),
            new Producto(5, "flotador", 56.12),
            new Producto(6, "bañador", 22.22),
        };
        Tienda tienda = new Tienda("juanito");
        for (Producto producto : productos)
            tienda.addProducto(producto);
        System.out.printf("Producto mas caro: %s%n", tienda.obtenerProductoMasCaro());
        System.out.printf("Producto mas barato: %s%n", tienda.obtenerProductoMasBarato());
        tienda.eliminarProducto(new Producto(3, null, 0));
        System.out.println("============================================");
        System.out.println(tienda);
        System.out.println("============================================");
        System.out.println("============================================");
        System.out.println(tienda.getProductos().toString().
                replace("]", "").replace("[",""));
        boolean atributo = true;
        String mensaje = "";
        //mensaje = atributo ? "SI" : "NO";
        if (atributo)
            mensaje = "SI";
        else
            mensaje = "NO";
        System.out.println(atributo + " " + mensaje);
        Map<Integer, String> diccionario = Map.of(1, "uno", 2, "dos", 3, "tres");
        Set<Integer> claves = diccionario.keySet();
        for (int clave : claves) {
            System.out.println("Clave: " + clave);
            System.out.println("Valor: " + diccionario.get(clave));
        }
    }

    // for(Set<Integer> claves : dic )




}
