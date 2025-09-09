package com.duoc;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InventarioTest {
    private Inventario inventario;

    @BeforeEach
    public void setUp() {
        inventario = new Inventario();
    }

    @Test
    public void testAgregarProducto() {
        Producto p = new Producto("001", "Zapatilla", "Deportiva", 39990, 5);
        inventario.agregarProducto(p);
        assertTrue(inventario.listarTodos().contains(p));
    }

    @Test
    public void testAgregarProductoNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            inventario.agregarProducto(null);
        });
    }

    @Test
    public void testEliminarProductoExistente() {
        Producto p = new Producto("002", "Polera", "Algodón", 9990, 10);
        inventario.agregarProducto(p);
        inventario.eliminarProducto("002");
        assertFalse(inventario.listarTodos().contains(p));
    }

    @Test
    public void testEliminarProductoInexistente() {
        assertDoesNotThrow(() -> inventario.eliminarProducto("999"));
    }

    @Test
    public void testBuscarProductoPorNombreExiste() {
        Producto p1 = new Producto("003", "Jeans", "Skinny", 19990, 3);
        Producto p2 = new Producto("004", "Jeans", "Wide leg", 20990, 2);
        inventario.agregarProducto(p1);
        inventario.agregarProducto(p2);
        List<Producto> encontrados = inventario.buscarPorNombre("Jeans");
        assertEquals(2, encontrados.size());
    }

    @Test
    public void testBuscarProductoPorNombreInexistente() {
        List<Producto> encontrados = inventario.buscarPorNombre("Abrigo");
        assertTrue(encontrados.isEmpty());
    }

    @Test
    public void testListarTodosLosProductos() {
        Producto p1 = new Producto("005", "Gorro", "Lana", 4990, 7);
        Producto p2 = new Producto("006", "Guantes", "Cuero", 9990, 4);
        inventario.agregarProducto(p1);
        inventario.agregarProducto(p2);
        List<Producto> productos = inventario.listarTodos();
        assertEquals(2, productos.size());
    }

}
