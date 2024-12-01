/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio1repaso;

/**
 *
 * @author tedax
 */
public class Pedido {
    private int id;
    private String id_cliente;
    private String fecha;
    private float precio_total;

    public Pedido(int id, String id_cliente, String fecha, float precio_total) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.fecha = fecha;
        this.precio_total = precio_total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(float precio_total) {
        this.precio_total = precio_total;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", id_cliente=" + id_cliente + ", fecha=" + fecha + ", precio_total=" + precio_total + '}';
    }

   
    
}
