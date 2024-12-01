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
public class PedidoDAO {
    
    public void listarPedidos(){
        
        String sql="SELECT * FROM pedido";
        try (Connection conn =ConexionBD.getConnection();
             PreparedStatement stmt =conn.prepareStatement(sql);
             ResultSet rs =stmt.executeQuery()){
            while (rs.next()) {
               int id =rs.getInt("id");
               String id_cliente=rs.getString("id_cliente");
               String fecha=rs.getString("fecha");
               Float precio_total=rs.getFloat("precio_total");
               
                System.out.println("Id: " +id+", id_cliente: " +id_cliente+", fecha: " +fecha +", precio_total: " +precio_total);
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean anadirPedidos(Pedido pedido) {
        
        String sql="INSERT INTO pedido (id_cliente, fecha, precio_total) VALUES (?, ?, ?)";
        
        try (Connection conn =ConexionBD.getConnection();
                PreparedStatement stmt=conn.prepareStatement(sql)){
          
            stmt.setString(1, pedido.getId_cliente());
            stmt.setString(2, pedido.getFecha());
            stmt.setFloat(3, pedido.getPrecio_total());
            
            
            int filasAfectadas =stmt.executeUpdate();
            return filasAfectadas  > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        
        
    }

    public boolean modificarPedidos(int idPedido, String idCliente, String fecha, float precioTotal) {
        String sql = "UPDATE pedido SET id_cliente = ?, fecha = ?, precio_total = ? WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idCliente);
            stmt.setString(2, fecha);
            stmt.setFloat(3, precioTotal);
            stmt.setInt(4, idPedido);

            int filasAfectadas = stmt.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace(); 
            return false;
        }
    }

    public boolean eliminarPedidos(int idPedido) {
        String sql = "DELETE FROM pedido WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPedido);

            int filasAfectadas = stmt.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
