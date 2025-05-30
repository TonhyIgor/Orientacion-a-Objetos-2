package tps.tp1.ejercicio2.tarjetas;

public class Visa extends Tarjeta {

    public Visa(double numero, int codigoSeguridad) {
        super(numero, codigoSeguridad);
    }

    @Override
    public float aplicarDescuento(float platos, float bebidas, float propina) {
        return platos + (bebidas * 0.97f) + propina;
    }
}
