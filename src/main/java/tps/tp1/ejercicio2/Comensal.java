package tps.tp1.ejercicio2;

import tps.tp1.ejercicio2.persistencia.RegistrarCosto;
import tps.tp1.ejercicio2.tarjetas.Tarjeta;

import java.time.LocalDate;

public class Comensal {
    private String nombre;
    private Tarjeta tarjeta;
    private Pedido pedido;
    private RegistrarCosto registrarCosto;

    public Comensal(String nombre, Tarjeta tarjeta, RegistrarCosto registrarCosto) {
        this.nombre = nombre;
        this.tarjeta = tarjeta;
        this.registrarCosto = registrarCosto;
    }

    protected void realizarPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    protected float pagar(float bebidas, float platos, float propina) {
        float montoTotal = bebidas + platos + propina;
        registrarCosto.registrar(LocalDate.now(), montoTotal);
        return tarjeta.aplicarDescuento(bebidas, platos, propina);
    }
}
