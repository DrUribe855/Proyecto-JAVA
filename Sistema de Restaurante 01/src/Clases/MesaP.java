package Clases;

public class MesaP {

    private int idFactura;
    private String nombrePlato;
    private int cantidadPlatos;
    private double subtotal;

    public MesaP(int idFactura, String nombrePlato, int cantidadPlatos, double subtotal) {
        this.idFactura = idFactura;
        this.nombrePlato = nombrePlato;
        this.cantidadPlatos = cantidadPlatos;
        this.subtotal = subtotal;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public int getCantidadPlatos() {
        return cantidadPlatos;
    }

    public void setCantidadPlatos(int cantidadPlatos) {
        this.cantidadPlatos = cantidadPlatos;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

}
