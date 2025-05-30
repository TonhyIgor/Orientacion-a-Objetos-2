package tps.tp1.ejercicio2.tarjetas;

public class OtraTarjeta extends Tarjeta {

    public OtraTarjeta(double numero, int codigoSeguridad) {
        super(numero, codigoSeguridad);
    }

    @Override
    public float aplicarDescuento(float bebidas, float platos, float propina) {
        return bebidas + platos + propina;
    }
}
