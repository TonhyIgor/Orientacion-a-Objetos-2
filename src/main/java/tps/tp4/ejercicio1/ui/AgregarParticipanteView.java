package tps.tp4.ejercicio1.ui;

import tps.tp4.ejercicio1.model.Persistencia;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarParticipanteView extends JFrame {
    private JTextField nombre;
    private JTextField telefono;
    private JTextField region;
    private Persistencia api;

    public AgregarParticipanteView(Persistencia api) {
        this.api = api;
    }

    public void launchView() {
        setTitle("Add Participant");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.nombre = new JTextField(10);
        this.telefono = new JTextField(10);
        this.region = new JTextField(10);
        this.nombre.setText("");
        this.telefono.setText("");
        this.region.setText("China");
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout());
        contentPane.add(new JLabel("Nombre: "));
        contentPane.add(nombre);
        contentPane.add(new JLabel("Telefono: "));
        contentPane.add(telefono);
        contentPane.add(new JLabel("Region: "));
        contentPane.add(region);
        JButton botonCargar = new JButton("Cargar");

        botonCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onBotonCargar();
            }
        });
        contentPane.add(botonCargar);
        setContentPane(contentPane);
        contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pack();
        setVisible(true);
    }

    //se tiene que eliminar el throws SQLException
    //ya que esto genera dependencia con la capa de database
    private void onBotonCargar() {
        try {
            this.api.agregarParticipante(nombre.getText(), telefono.getText(), region.getText());
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


