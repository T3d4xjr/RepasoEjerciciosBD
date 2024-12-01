/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio1repaso;

import java.util.Scanner;

/**
 *
 * @author tedax
 */
public class Menu {
    private static final PedidoDAO pedidoDAO = new  PedidoDAO();
    private static final ClienteDAO clienteDAO = new ClienteDAO();
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int opcion;
        do {            
            System.out.println("Menu:");
            System.out.println("1.Listar Cliente");
            System.out.println("2.Añadir cliente");
            System.out.println("3.Modificar cliente");
            System.out.println("4.Eliminar cliente");
            System.out.println("5.Listar pedido");
            System.out.println("6.Añadir pedido");
            System.out.println("7.Modificar pedido");
            System.out.println("8.Eliminar pedido");
            System.out.println("9.Salir");
            System.out.print("Seleccione una opción: ");
            opcion=sc.nextInt();
            sc.nextLine();
            
            switch (opcion) {
                case 1:
                    listarClientes();
                    break;
                case 2:
                    anadirCliente(sc);
                    break;
                case 3:
                    modificarCliente(sc);
                    break;
                case 4:
                    eliminarCliente(sc);
                    break;
                case 5:
                    listarPedidos();
                    break;
                case 6:
                    anadirPedidos(sc);
                    break;
                case 7:
                    modificarPedidos(sc);
                    break;
                case 8:
                    eliminarPedidos(sc);
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                
                default:
                    System.err.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion!=9);
        
        
    }
    
    private static void listarClientes(){
        clienteDAO.listarClientes();
    }
    private static void anadirCliente(Scanner sc){
        System.out.println("Dime el nombre a añadir");
        String nombre =sc.nextLine();
        System.out.println("Dime el email a añadir");
        String email =sc.nextLine();
        System.out.println("Dime el ciudad a añadir");
        String ciudad =sc.nextLine();
        System.out.println("Dime el telefono a añadir");
        String telefono =sc.nextLine();
        
        Cliente cliente =new Cliente(0, nombre, email, ciudad, telefono);
        
        if(clienteDAO.anadirCliente(cliente)){
            System.out.println("Cliente Añadido emailsxitosamente");
        }else{
            System.err.println("Fallo al añadir el cliente");
        }
        
        
    }
    private static void modificarCliente(Scanner sc) {
        System.out.print("Introduce el email del cliente a modificar: ");
        String email = sc.nextLine();

        System.out.print("Introduce el nuevo nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce el nuevo teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Introduce la nueva ciudad: ");
        String ciudad = sc.nextLine();

        if (clienteDAO.modificarCliente(email, nombre, telefono, ciudad)) {
            System.out.println("Cliente modificado con éxito.");
        } else {
            System.err.println("No se encontró el cliente con el email proporcionado o ocurrió un error.");
        }
    }
    private static void eliminarCliente(Scanner sc) {
        System.out.print("Introduce el email del cliente a eliminar: ");
        String email = sc.nextLine();

        if (clienteDAO.eliminarCliente(email)) {
            System.out.println("Cliente eliminado con éxito.");
        } else {
            System.err.println("No se encontró el cliente con el email proporcionado o ocurrió un error.");
        }
    }


    private static void listarPedidos(){
       pedidoDAO.listarPedidos();
    }
    private static void anadirPedidos(Scanner sc){
        System.out.println("Añadir id_cliente ");
        String id_cliente=sc.nextLine();
        System.out.println("Añadir fecha: (YYYY-MM-DD)");
        String fecha=sc.nextLine();
        System.out.println("Añadir precio_total ");
        float precio_total=sc.nextFloat();
        
        Pedido pedido =new Pedido(0, id_cliente, fecha, precio_total);
        if(pedidoDAO.anadirPedidos(pedido)){
            System.out.println("Pedio añadido exitosamente");
        }else{
            System.err.println("Ocurriro un error al añadir el pedido");
        }
        
    }
    
    private static void modificarPedidos(Scanner sc) {
        System.out.print("Introduce el ID del pedido a modificar: ");
        int idPedido = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        System.out.print("Introduce el nuevo ID del cliente: ");
        String idCliente = sc.nextLine();

        System.out.print("Introduce la nueva fecha (YYYY-MM-DD): ");
        String fecha = sc.nextLine();

        System.out.print("Introduce el nuevo precio total: ");
        float precioTotal = sc.nextFloat();
        sc.nextLine(); // Limpiar el buffer

        if (pedidoDAO.modificarPedidos(idPedido, idCliente, fecha, precioTotal)) {
            System.out.println("Pedido modificado con éxito.");
        } else {
            System.err.println("No se pudo modificar el pedido. Verifica los datos ingresados.");
        }
    }

    private static void eliminarPedidos(Scanner sc) {
        System.out.print("Introduce el ID del pedido a eliminar: ");
        int idPedido = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        if (pedidoDAO.eliminarPedidos(idPedido)) {
            System.out.println("Pedido eliminado con éxito.");
        } else {
            System.err.println("No se pudo eliminar el pedido. Verifica el ID ingresado.");
        }
    }

}
