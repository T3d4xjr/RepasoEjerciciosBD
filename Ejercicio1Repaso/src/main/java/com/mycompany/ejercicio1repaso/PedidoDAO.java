/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio1repaso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tedax
 */
public class PedidoDAO {

    // Método para listar todos los pedidos
    public List<Pedido> listarPedidos() throws SQLException {
        List<Pedido> pedidos = new ArrayList<>();
        String query = "SELECT * FROM pedido";
        
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Pedido pedido = new Pedido(
                        rs.getInt("id"),
                        rs.getString("id_cliente"),
                        rs.getString("fecha"),
                        rs.getFloat("precio_total")
                );
                pedidos.add(pedido);
            }
        }
        return pedidos;
    }

    // Método para añadir un nuevo pedido
    public void añadirPedido(int idCliente, String fecha, float precioTotal) throws SQLException {
        String query = "INSERT INTO pedido (id_cliente, fecha, precio_total) VALUES (?, ?, ?)";
        
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, idCliente);
            pstmt.setString(2, fecha);
            pstmt.setFloat(3, precioTotal);
            
            pstmt.executeUpdate();
        }
    }

    // Método para modificar un pedido por ID
    public void modificarPedidoPorId(int idPedido, String nuevaFecha, float nuevoPrecioTotal) throws SQLException {
        String query = "UPDATE pedido SET fecha = ?, precio_total = ? WHERE id = ?";
        
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, nuevaFecha);
            pstmt.setFloat(2, nuevoPrecioTotal);
            pstmt.setInt(3, idPedido);
            
            pstmt.executeUpdate();
        }
    }

    // Método para eliminar un pedido por ID
    public void eliminarPedidoPorId(int idPedido) throws SQLException {
        String query = "DELETE FROM pedido WHERE id = ?";
        
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, idPedido);
            pstmt.executeUpdate();
        }
    }
}