package tps.tp1.ejercicio2;

import java.util.List;

public final class Pedido {
    private List<Item> platos;
    private List<Item> bebidas;

    public Pedido(List<Item> platos, List<Item> bebidas) {
        this.platos = platos;
        this.bebidas = bebidas;
    }

    protected float precioPlatos() {
        return platos.stream().map(Item::getPrecio).reduce(0f, Float::sum);
    }

    protected float precioBebidas() {
        return bebidas.stream().map(Item::getPrecio).reduce(0f, Float::sum);
    }

    protected float precioTotal() {
        return precioPlatos() + precioBebidas();
    }
}