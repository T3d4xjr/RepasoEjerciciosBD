package com.mycompany.ejercicio1repaso;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static Ej1Controller controller = new Ej1Controller();  // Crear instancia del controlador

    public static void main(String[] args) throws SQLException {
        int opcion;

        do {
            // Menú de opciones
            System.out.println("BD Ejer9");
            System.out.println("1. Listar clientes");
            System.out.println("2. Añadir cliente");
            System.out.println("3. Modificar cliente por email");
            System.out.println("4. Eliminar cliente por email");
            System.out.println("5. Listar pedidos");
            System.out.println("6. Añadir pedido");
            System.out.println("7. Modificar pedido por ID");
            System.out.println("8. Eliminar pedido por ID");
            System.out.println("9. Salir");

            // Leer la opción seleccionada
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer del scanner

            // Ejecutar la acción según la opción seleccionada
            switch (opcion) {
                case 1:
                    // Listar clientes
                    controller.listarClientes();
                    break;
                case 2:
                    // Añadir cliente
                    controller.añadirCliente();
                    break;
                case 3:
                    // Modificar cliente
                    controller.modificarClientePorEmail();
                    break;
                case 4:
                    // Eliminar cliente
                    controller.eliminarClientePorEmail();
                    break;
                case 5:
                    // Listar pedidos
                    controller.listarPedidos();
                    break;
                case 6:
                    // Añadir pedido
                    controller.añadirPedido();
                    break;
                case 7:
                    // Modificar pedido
                    controller.modificarPedidoPorId();
                    break;
                case 8:
                    // Eliminar pedido
                    controller.eliminarPedidoPorId();
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor seleccione de nuevo.");
            }
        } while (opcion != 9);  // El ciclo continuará hasta que la opción seleccionada sea 9 (Salir)
        
        scanner.close();  // Cerrar el scanner al finalizar
    }
}
