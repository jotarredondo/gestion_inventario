package com.duoc;

public class Producto {

    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad;

    public Producto(String codigo, String nombre, String descripcion, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public void actualizarPrecio(double nuevoPrecio) {
        this.precio = nuevoPrecio;
    }

    public String descripcionDetallada() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Descripción: " + descripcion +
                ", Precio: $" + precio + ", Stock: " + cantidad;
    }
}
