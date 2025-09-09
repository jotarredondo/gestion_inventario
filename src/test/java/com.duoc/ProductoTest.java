package com.duoc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductoTest {

    @Test
    public void testCreacionProducto() {
        Producto p = new Producto("001", "Zapatilla", "Deportiva", 39990, 5);
        assertEquals("Zapatilla", p.getNombre());
        assertEquals("Deportiva", p.getDescripcion());
        assertEquals(39990, p.getPrecio());
        assertEquals(5, p.getCantidad());
    }

    @Test
    public void testActualizarPrecio() {
        Producto p = new Producto("002", "Polera", "Algodón", 9990, 10);
        p.actualizarPrecio(11990);
        assertEquals(11990, p.getPrecio());
    }

    @Test
    public void testActualizarCantidadStock() {
        Producto p = new Producto("003", "Jeans", "Skinny fit", 19990, 3);
        p.setCantidad(7);
        assertEquals(7, p.getCantidad());
    }
}
