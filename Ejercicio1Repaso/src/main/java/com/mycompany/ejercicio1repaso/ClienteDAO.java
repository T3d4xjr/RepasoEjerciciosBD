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
public class ClienteDAO {

    // Método para listar todos los clientes
    public List<Cliente> listarClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM cliente";
        
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareCall(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("ciudad"),
                        rs.getString("telefono")
                );
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    // Método para añadir un nuevo cliente
    public void añadirCliente(String nombre, String email, String ciudad, String telefono) throws SQLException {
        String query = "INSERT INTO cliente (nombre, email, ciudad, telefono) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, nombre);
            pstmt.setString(2, email);
            pstmt.setString(3, ciudad);
            pstmt.setString(4, telefono);
            
            pstmt.executeUpdate();
        }
    }

    // Método para modificar un cliente por email
    public void modificarClientePorEmail(String email, String nuevoNombre, String nuevaCiudad, String nuevoTelefono) throws SQLException {
        String query = "UPDATE cliente SET nombre = ?, ciudad = ?, telefono = ? WHERE email = ?";
        
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, nuevoNombre);
            pstmt.setString(2, nuevaCiudad);
            pstmt.setString(3, nuevoTelefono);
            pstmt.setString(4, email);
            
            pstmt.executeUpdate();
        }
    }

    // Método para eliminar un cliente por email
    public void eliminarClientePorEmail(String email) throws SQLException {
        String query = "DELETE FROM cliente WHERE email = ?";
        
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, email);
            pstmt.executeUpdate();
        }
    }

}
