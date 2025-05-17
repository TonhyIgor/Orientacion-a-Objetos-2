package tps.tp1.ejercicio1;

import jakarta.mail.MessagingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTest {
    private List<Inscripcion> listaInscripciones;
    private Participante participante;

    @BeforeEach
    void setUp() {
        listaInscripciones = new ArrayList<>();
        participante = new Participante("nombre1", "apellido1", 123456, "p2222");
    }

    @Test
    void testInscribir() {
        listaInscripciones = new ArrayList<>();
        var participante = new Participante("nombre1", "apellido1", 123456, "p2222");
        var registro = new EnMemoriaRegistrarInscripcion();
        var informador = new FakeInformar();
        var concurso = new Concurso(listaInscripciones,
                LocalDate.now(),
                LocalDate.now().plusDays(1),
                "c2222", registro, informador);
        concurso.inscribirPersona(participante);
        assertTrue(concurso.existeInscripcionParticipante(participante));
    }

    @Test
    void testIncribirPrimerDia() {
        listaInscripciones = new ArrayList<>();
        var participante = new Participante("nombre1", "apellido1", 123456, "p2222");
        var registro = new EnMemoriaRegistrarInscripcion();
        var informador = new FakeInformar();
        var concurso = new Concurso(listaInscripciones,
                LocalDate.now(),
                LocalDate.now().plusDays(1),
                "c2222", registro, informador);
        concurso.inscribirPersona(participante);
        assertEquals(10, participante.getPuntos());
    }

    @Test
    void testIncribirFueraDeRango() {
        listaInscripciones = new ArrayList<>();
        var participante = new Participante("nombre1", "apellido1", 123456, "p2222");
        var registro = new EnMemoriaRegistrarInscripcion();
        var informador = new FakeInformar();
        var concurso = new Concurso(listaInscripciones,
                LocalDate.now().plusDays(3),
                LocalDate.now(),
                "c2222", registro, informador);
        assertThrows(RuntimeException.class, () -> concurso.inscribirPersona(participante));
        assertFalse(concurso.existeInscripcionParticipante(participante));
    }

    @Test
    void testRegistro() throws MessagingException {
        var registro = new EnMemoriaRegistrarInscripcion();
        var informador = new FakeInformar();
        var concurso = new Concurso(listaInscripciones,
                LocalDate.now(),
                LocalDate.now().plusDays(1),
                "c2222", registro, informador);
        concurso.inscribirPersona(participante);
        assertEquals(valorEsperadoExportar(), registro.getData());
    }

    @Test
    void testInformar() {
        var registro = new EnMemoriaRegistrarInscripcion();
        var informador = new FakeInformar();
        var concurso = new Concurso(listaInscripciones,
                LocalDate.now(),
                LocalDate.now().plusDays(1),
                "c2222", registro, informador);
        concurso.inscribirPersona(participante);
        assertEquals(valorEsperadoInformar(), informador.getData());
    }

    String valorEsperadoExportar() {
        return LocalDate.now() + ", " + "p2222" + ", " + "c2222";
    }

    String valorEsperadoInformar() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Inscripcion exitosa al concurso c2222, El participante p2222 se ha inscripto al concurso c2222 el dia " + LocalDate.now().format(formato);
    }
}
