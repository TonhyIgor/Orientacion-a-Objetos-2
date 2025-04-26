package tps.tp1.ejercicio2.persistencia;

import java.sql.*;
import java.time.LocalDate;

public class PedidoJDBC implements RegistrarCosto {
    private final static String conexion = "jdbc:mysql://localhost:3306/poo2-tp2-3/";
    private final static String usuario = "root";
    private final static String clave = "123456";

    @Override
    public void registrar(LocalDate fecha, float costo) {
        create(fecha, costo);
    }

    private void create(LocalDate fecha, float montoTotal) {
        String consultaSQL = "INSERT INTO pedido (fecha,montoTotal) VALUES (?, ?)";

        try (Connection myConexion = DriverManager.getConnection(conexion, usuario, clave);
             PreparedStatement statementCrear = myConexion.prepareStatement(consultaSQL)) {
            statementCrear.setDate(1, Date.valueOf(fecha));
            statementCrear.setFloat(2, montoTotal);
            statementCrear.executeUpdate();
        } catch (SQLException S) {
            throw new RuntimeException("Error en la base de datos");
        }
    }
}
