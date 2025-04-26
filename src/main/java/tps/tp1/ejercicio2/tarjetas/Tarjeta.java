package tps.tp1.ejercicio2.tarjetas;

public abstract class Tarjeta {
    private double numero;
    private int codigoSeguridad;

    public Tarjeta(double numero, int codigoSeguridad) {
        this.numero = numero;
        this.codigoSeguridad = codigoSeguridad;
    }

    public abstract float aplicarDescuento(float bebidas, float platos, float propina);
}
