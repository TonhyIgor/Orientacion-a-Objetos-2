package tps.tp4.main;

import tps.tp4.AgregarParticipante;

import java.awt.*;
import java.sql.SQLException;

public class Main {
    private static final String URL = "jdbc:derby://localhost:1527/participantes";
    private static final String USER = "app";
    private static final String PASSWORD = "app";

    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AgregarParticipante();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}
