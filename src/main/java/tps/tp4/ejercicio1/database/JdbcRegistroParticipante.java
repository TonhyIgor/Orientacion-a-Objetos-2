package tps.tp4.ejercicio1.database;

import tps.tp4.ejercicio1.model.Participante;
import tps.tp4.ejercicio1.model.RegistroParticipante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcRegistroParticipante implements RegistroParticipante {
    private String url;
    private String user;
    private String password;

    public JdbcRegistroParticipante(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    private Connection open() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void registrarParticipante(Participante participante) {
        try (var conexion = open();
             PreparedStatement st = conexion
                     .prepareStatement("insert into participantes(nombre, telefono, region) values(?,?,?)");) {
            st.setString(1, participante.nombre());
            st.setString(2, participante.telefono());
            st.setString(3, participante.region());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Hubo un problema con la base de datos" + e);
        }
    }
}
