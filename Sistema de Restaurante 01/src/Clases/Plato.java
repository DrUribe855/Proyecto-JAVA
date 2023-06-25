package Clases;

public class Plato {

    private String nombre;
    private double precio;
    private int identificador;

    public Plato(int identificador, String nombre, double precio) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getidentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
