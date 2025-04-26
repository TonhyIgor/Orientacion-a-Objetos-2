package tps.tp4.database;

import tps.tp4.model.Participante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcABMParticipante {
    private Connection dbConn;


    public void Conexion(Participante participante) throws SQLException {
        this.dbConn = DriverManager.getConnection(url, user, password);
        PreparedStatement st = dbConn
                .prepareStatement("insert into participantes(nombre, telefono, region) values(?,?,?)");
        try {
            st.setString(1, participante.nombre());
            st.setString(2, participante.telefono());
            st.setString(3, participante.region());
            st.executeUpdate();
        } finally {
            st.close();
        }
    }
}
