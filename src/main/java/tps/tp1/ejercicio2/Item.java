package tps.tp1.ejercicio2;

public class Item {
    private String nombre;
    private String descripcion;
    private float precio;

    public Item(String nombre, String descripcion, float precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    protected float getPrecio() {
        return precio;
    }

}
