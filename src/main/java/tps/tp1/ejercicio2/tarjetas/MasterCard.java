package tps.tp1.ejercicio2.tarjetas;

public class MasterCard extends Tarjeta {

    public MasterCard(double numero, int codigoSeguridad) {
        super(numero, codigoSeguridad);
    }

    @Override
    public float aplicarDescuento(float platos, float bebidas, float propina) {
        return (platos * 0.98f) + bebidas + propina;
    }
}
