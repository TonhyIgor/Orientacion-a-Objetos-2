package tps.tp1.ejercicio2.tarjetas;

public class ComarcaPlus extends Tarjeta {
    private double numero;
    private int codigoSeguridad;
    private float saldo;

    public ComarcaPlus(double numero, int codigoSeguridad) {
        super(numero, codigoSeguridad);
        this.numero = numero;
        this.codigoSeguridad = codigoSeguridad;
        this.saldo = saldo;
    }

    @Override
    public float aplicarDescuento(float platos, float bebidas, float propina) {
        return ((platos + bebidas) * 0.98f) + propina;
    }
}
