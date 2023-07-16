
package Clases;
    
public class Factura {
    private String id_venta;
    private String fecha;
    private String total;
    private String idMesaPedido;
    private String numeroMesa;

    public Factura(String id_venta, String fecha, String total, String idMesaPedido, String numeroMesa) {
        this.id_venta = id_venta;
        this.fecha = fecha;
        this.total = total;
        this.idMesaPedido = idMesaPedido;
        this.numeroMesa = numeroMesa;
    }

    public String getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(String numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public String getIdMesaPedido() {
        return idMesaPedido;
    }

    public void setIdMesaPedido(String idMesaPedido) {
        this.idMesaPedido = idMesaPedido;
    }
    
     public String getId_venta() {
        return id_venta;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTotal() {
        return total;
    }

    
}
