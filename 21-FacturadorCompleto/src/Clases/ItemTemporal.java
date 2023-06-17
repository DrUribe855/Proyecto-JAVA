
package Clases;


public class ItemTemporal {
    private String id_producto;
    private String cantidad;
    private String subtotal;

    public ItemTemporal(String id_producto, String cantidad, String subtotal) {
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }
    
    
    
}
