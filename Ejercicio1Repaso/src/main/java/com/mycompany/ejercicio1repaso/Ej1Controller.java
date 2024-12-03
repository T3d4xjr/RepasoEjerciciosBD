/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio1repaso;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tedax
 */
public class Ej1Controller {

    private ClienteDAO clienteDAO = new ClienteDAO();
    private PedidoDAO pedidoDAO = new PedidoDAO();
    private Scanner scanner = new Scanner(System.in);

   // Listar todos los clientes
    public void listarClientes() throws SQLException {
        List<Cliente> clientes = clienteDAO.listarClientes();
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    // Añadir un nuevo cliente
    public void añadirCliente() throws SQLException {
        // Solicitar los datos al usuario
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el email del cliente: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese la ciudad del cliente: ");
        String ciudad = scanner.nextLine();
        System.out.print("Ingrese el teléfono del cliente: ");
        String telefono = scanner.nextLine();

        // Llamar al método del ClienteDAO para añadir el cliente
        clienteDAO.añadirCliente(nombre, email, ciudad, telefono);
        System.out.println("Cliente añadido correctamente.");
    }

    // Modificar un cliente por su email
    public void modificarClientePorEmail() throws SQLException {
        // Solicitar al usuario el email del cliente a modificar
        System.out.print("Ingrese el email del cliente a modificar: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese el nuevo nombre del cliente: ");
        String nuevoNombre = scanner.nextLine();
        System.out.print("Ingrese la nueva ciudad del cliente: ");
        String nuevaCiudad = scanner.nextLine();
        System.out.print("Ingrese el nuevo teléfono del cliente: ");
        String nuevoTelefono = scanner.nextLine();

        // Llamar al método del ClienteDAO para modificar el cliente
        clienteDAO.modificarClientePorEmail(email, nuevoNombre, nuevaCiudad, nuevoTelefono);
        System.out.println("Cliente modificado correctamente.");
    }

    // Eliminar un cliente por su email
    public void eliminarClientePorEmail() throws SQLException {
        // Solicitar el email del cliente a eliminar
        System.out.print("Ingrese el email del cliente a eliminar: ");
        String email = scanner.nextLine();

        // Llamar al método del ClienteDAO para eliminar el cliente
        clienteDAO.eliminarClientePorEmail(email);
        System.out.println("Cliente eliminado correctamente.");
    }
     // Listar todos los pedidos
    public void listarPedidos() throws SQLException {
        List<Pedido> pedidos = pedidoDAO.listarPedidos();
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }
    }

    // Añadir un nuevo pedido
    public void añadirPedido() throws SQLException {
        // Solicitar los datos al usuario
        System.out.print("Ingrese el ID del cliente para el pedido: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer del scanner

        System.out.print("Ingrese la fecha del pedido (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();

        System.out.print("Ingrese el precio total del pedido: ");
        float precioTotal = scanner.nextFloat();

        // Llamar al método del PedidoDAO para añadir el pedido
        pedidoDAO.añadirPedido(idCliente, fecha, precioTotal);
        System.out.println("Pedido añadido correctamente.");
    }

    // Modificar un pedido por su ID
    public void modificarPedidoPorId() throws SQLException {
        // Solicitar al usuario el ID del pedido a modificar
        System.out.print("Ingrese el ID del pedido a modificar: ");
        int idPedido = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer del scanner

        System.out.print("Ingrese la nueva fecha del pedido (YYYY-MM-DD): ");
        String nuevaFecha = scanner.nextLine();

        System.out.print("Ingrese el nuevo precio total del pedido: ");
        float nuevoPrecioTotal = scanner.nextFloat();

        // Llamar al método del PedidoDAO para modificar el pedido
        pedidoDAO.modificarPedidoPorId(idPedido, nuevaFecha, nuevoPrecioTotal);
        System.out.println("Pedido modificado correctamente.");
    }

    // Eliminar un pedido por su ID
    public void eliminarPedidoPorId() throws SQLException {
        // Solicitar el ID del pedido a eliminar
        System.out.print("Ingrese el ID del pedido a eliminar: ");
        int idPedido = scanner.nextInt();

        // Llamar al método del PedidoDAO para eliminar el pedido
        pedidoDAO.eliminarPedidoPorId(idPedido);
        System.out.println("Pedido eliminado correctamente.");
    }
}