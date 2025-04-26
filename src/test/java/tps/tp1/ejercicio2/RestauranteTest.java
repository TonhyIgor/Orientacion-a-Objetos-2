package tps.tp1.ejercicio2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tps.tp1.ejercicio2.tarjetas.ComarcaPlus;
import tps.tp1.ejercicio2.tarjetas.MasterCard;
import tps.tp1.ejercicio2.tarjetas.OtraTarjeta;
import tps.tp1.ejercicio2.tarjetas.Visa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestauranteTest {
    private Pedido miPedido;


    @BeforeEach
    void setUp() {
        List<Item> platos = new ArrayList<>();
        List<Item> bebidas = new ArrayList<>();
        platos.add(new Item("Milanesa de carne", "Milanesa de carne", 200));
        platos.add(new Item("Papas fritas", "Papas fritas", 100));
        bebidas.add(new Item("Coca Cola", "Coca Cola", 100));
        miPedido = new Pedido(platos, bebidas);
    }

    @Test
    void pagarConVisa() {
        var visa = new Visa(123456789, 123);
        var registrador = new EnMemoriaRegistrarCosto();
        Comensal comensal = new Comensal("nombre1", visa, registrador);
        comensal.realizarPedido(miPedido);
        assertEquals(405.0, comensal.pagar(miPedido.precioPlatos(), miPedido.precioBebidas(), (miPedido.precioTotal() * 0.02f)));
    }

    @Test
    void pagarConMasterCard() {
        var masterCard = new MasterCard(123456789, 123);
        var registrador = new EnMemoriaRegistrarCosto();
        Comensal comensal = new Comensal("nombre1", masterCard, registrador);
        comensal.realizarPedido(miPedido);
        assertEquals(402.0, comensal.pagar(miPedido.precioPlatos(), miPedido.precioBebidas(), (miPedido.precioTotal() * 0.02f)));
    }

    @Test
    void pagarConComarcaPlus() {
        var comarcaPlus = new ComarcaPlus(123456789, 123);
        var registrador = new EnMemoriaRegistrarCosto();
        Comensal comensal = new Comensal("nombre1", comarcaPlus, registrador);
        comensal.realizarPedido(miPedido);
        assertEquals(400.0, comensal.pagar(miPedido.precioPlatos(), miPedido.precioBebidas(), (miPedido.precioTotal() * 0.02f)));
    }

    @Test
    void pagarConOtraTarjeta() {
        var otraTarjeta = new OtraTarjeta(123456789, 123);
        var registrador = new EnMemoriaRegistrarCosto();
        Comensal comensal = new Comensal("nombre1", otraTarjeta, registrador);
        comensal.realizarPedido(miPedido);
        assertEquals(408.0, comensal.pagar(miPedido.precioPlatos(), miPedido.precioBebidas(), (miPedido.precioTotal() * 0.02f)));
    }

    @Test
    void testRegistro() {
        var visa = new Visa(123456789, 123);
        var registrador = new EnMemoriaRegistrarCosto();
        Comensal comensal = new Comensal("nombre1", visa, registrador);
        comensal.realizarPedido(miPedido);
        comensal.pagar(miPedido.precioPlatos(), miPedido.precioBebidas(), (miPedido.precioTotal() * 0.02f));
        assertEquals(valorEsperado(), registrador.getData());
    }

    String valorEsperado() {
        float montoTotal = miPedido.precioPlatos() + miPedido.precioBebidas() + miPedido.precioTotal() * 0.02f;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.now().format(formato) + " || " + montoTotal;
    }
}
