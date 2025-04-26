package tps.tp1.ejercicio1;

import tps.tp1.ejercicio1.comunicacion.InformarInscripcion;

public class FakeInformar implements InformarInscripcion {
    private String data;

    @Override
    public void informar(String titulo, String cuerpo) {
        this.data = titulo + ", " + cuerpo;
    }

    public String getData() {
        return this.data;
    }
}
