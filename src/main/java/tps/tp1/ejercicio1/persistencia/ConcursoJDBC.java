package tps.tp1.ejercicio1.persistencia;

import java.sql.*;
import java.time.LocalDate;

public class ConcursoJDBC implements RegistrarInscripcion {
    private final static String conexion = "jdbc:mysql://localhost:3306/poo2-tp2-3";
    private final static String usuario = "root";
    private final static String clave = "123456";

    @Override
    public void exportar(LocalDate fecha, String idParticipante, String idConcurso) {
        create(fecha, idParticipante, idConcurso);
    }

    private void create(LocalDate fecha, String idParticipante, String idConcurso) {
        String consultaSQL = "INSERT INTO concurso (fecha,idParticipante,idConcurso) VALUES (?, ?, ?)";

        try (Connection myConexion = DriverManager.getConnection(conexion, usuario, clave);
             PreparedStatement statementCrear = myConexion.prepareStatement(consultaSQL)) {
            statementCrear.setDate(1, Date.valueOf(fecha));
            statementCrear.setString(2, idParticipante);
            statementCrear.setString(3, idConcurso);
            statementCrear.executeUpdate();
        } catch (SQLException S) {
            throw new RuntimeException("Ha ocurrido un error: " + S);
        }
    }
}
