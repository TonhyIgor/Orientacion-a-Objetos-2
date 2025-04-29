package tps.tp4.ejercicio1.main;

import tps.tp4.ejercicio1.database.JdbcRegistroParticipante;
import tps.tp4.ejercicio1.model.ApiPersistencia;
import tps.tp4.ejercicio1.ui.AgregarParticipanteView;

import java.sql.SQLException;

public class Main {
    private static final String URL = "jdbc:derby://localhost:1527/participantes";
    private static final String USER = "app";
    private static final String PASSWORD = "app";

    public static void main(String[] args) throws SQLException {
        /*EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AgregarParticipante();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });*/
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    JdbcRegistroParticipante manejoParticipante = new JdbcRegistroParticipante(URL, USER, PASSWORD);
                    ApiPersistencia api = new ApiPersistencia(manejoParticipante);
                    new AgregarParticipanteView(api).launchView();
                } catch (Exception e) {
                    throw new RuntimeException("Hubo un problema al inicio" + e);
                }
            }
        });
    }
}
