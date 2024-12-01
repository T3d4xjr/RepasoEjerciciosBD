/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio1repaso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tedax
 */
public class ClienteDAO {

    
    public void listarClientes(){
    String sql ="SELECT * FROM cliente";
    
        try(Connection conn =ConexionBD.getConnection();
            PreparedStatement stmt =conn.prepareStatement(sql);
            ResultSet rs =stmt.executeQuery()) {
            
            while (rs.next()) {
                 int id = rs.getInt("id");
                String nombre =rs.getString("nombre");
                String email =rs.getString("email");
                String ciudad =rs.getString("ciudad");
                String telefono =rs.getString("telefono");
                
                System.out.println("Id: "+id+", nombre :" +nombre+", email :"+email+", ciudad :"+ciudad+", telefono :"+telefono);
                
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean anadirCliente(Cliente cliente) {
       
        String sql ="INSERT INTO cliente (nombre, email, ciudad, telefono) VALUES (?, ?, ?, ?)";
        
        
        
        try (Connection conn=ConexionBD.getConnection();
             PreparedStatement stmt =conn.prepareStatement(sql)){
            
            stmt.setString(1,cliente.getNombre());
            stmt.setString(2,cliente.getEmail());
            stmt.setString(3,cliente.getCiudad());
            stmt.setString(4,cliente.getTelefono());
            
            int filasafectadas =stmt.executeUpdate();
            
            return  filasafectadas > 0;
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        
       
    }

    public boolean modificarCliente(String email, String nombre, String telefono, String ciudad) {
      String sql = "UPDATE cliente SET nombre = ?, telefono = ?, ciudad = ? WHERE email = ?";
    try (Connection conn = ConexionBD.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nombre);
        stmt.setString(2, telefono);
        stmt.setString(3, ciudad);
        stmt.setString(4, email);

        int filasAfectadas = stmt.executeUpdate();

        return filasAfectadas > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
      
    }

    public boolean eliminarCliente(String email) {
    
        String sql = "DELETE FROM cliente WHERE email = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);

            int filasAfectadas = stmt.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
