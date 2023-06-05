/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

public class ListaFacturas {

    private String cedula_cliente;
    private String nombre_cliente;
    private String direccion;
    private String cedula_vendedor;
    private String nombre_vendedor;
    private String id_producto;
    private String nombre_p;
    private String cantidad;
    private int total;

    public ListaFacturas(String cedula_cliente, String nombre_cliente, String direccion, String cedula_vendedor, String nombre_vendedor, String id_producto, String nombre_p, String cantidad, int total) {
        this.cedula_cliente = cedula_cliente;
        this.nombre_cliente = nombre_cliente;
        this.direccion = direccion;
        this.cedula_vendedor = cedula_vendedor;
        this.nombre_vendedor = nombre_vendedor;
        this.id_producto = id_producto;
        this.nombre_p = nombre_p;
        this.cantidad = cantidad;
        this.total = total;
    }

    public String getCedula_cliente() {
        return cedula_cliente;
    }

    public void setCedula_cliente(String cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula_vendedor() {
        return cedula_vendedor;
    }

    public void setCedula_vendedor(String cedula_vendedor) {
        this.cedula_vendedor = cedula_vendedor;
    }

    public String getNombre_vendedor() {
        return nombre_vendedor;
    }

    public void setNombre_vendedor(String nombre_vendedor) {
        this.nombre_vendedor = nombre_vendedor;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_p() {
        return nombre_p;
    }

    public void setNombre_p(String nombre_p) {
        this.nombre_p = nombre_p;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
