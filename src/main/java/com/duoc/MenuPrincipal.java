package com.duoc;

import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventario inventario = new Inventario();
        int opcion;

        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Buscar producto por código");
            System.out.println("4. Buscar producto por nombre");
            System.out.println("5. Listar inventario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Código: ");
                    String codigo = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Descripción: ");
                    String descripcion = sc.nextLine();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();
                    inventario.agregarProducto(new Producto(codigo, nombre, descripcion, precio, cantidad));
                    System.out.println("Producto agregado.");
                }
                case 2 -> {
                    System.out.print("Código del producto a eliminar: ");
                    String codigo = sc.nextLine();
                    boolean eliminado = inventario.eliminarProducto(codigo);
                    System.out.println(eliminado ? "Producto eliminado." : "Producto no encontrado.");
                }
                case 3 -> {
                    System.out.print("Código a buscar: ");
                    String codigo = sc.nextLine();
                    Producto encontrado = inventario.buscarPorCodigo(codigo);
                    if (encontrado != null) {
                        System.out.println("Producto encontrado:");
                        System.out.println(encontrado.descripcionDetallada());
                    } else {
                        System.out.println("No se encontró el producto.");
                    }
                }
                case 4 -> {
                    System.out.print("Nombre a buscar: ");
                    String nombre = sc.nextLine();
                    var resultados = inventario.buscarPorNombre(nombre);
                    if (resultados.isEmpty()) {
                        System.out.println("No se encontraron productos.");
                    } else {
                        System.out.println("Productos encontrados:");
                        for (Producto p : resultados) {
                            System.out.println(p.descripcionDetallada());
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Inventario:");
                    for (Producto p : inventario.listarTodos()) {
                        System.out.println(p.descripcionDetallada());
                    }
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }
}