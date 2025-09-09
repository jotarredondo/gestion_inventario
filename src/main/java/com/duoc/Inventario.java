package com.duoc;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventario {

    private HashMap<String, Producto> productos;

    public Inventario() {
        productos = new HashMap<>();
    }

    public void agregarProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser null.");
        }
        productos.put(producto.getCodigo(), producto);
    }

    public boolean eliminarProducto(String codigo) {
        return productos.remove(codigo) != null;
    }

    public Producto buscarPorCodigo(String codigo) {
        return productos.get(codigo);
    }

    public ArrayList<Producto> buscarPorNombre(String nombre) {
        ArrayList<Producto> resultados = new ArrayList<>();
        for (Producto p : productos.values()) {
            if (p.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    public ArrayList<Producto> listarTodos() {
        return new ArrayList<>(productos.values());
    }


}
