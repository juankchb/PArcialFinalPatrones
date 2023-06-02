package vista;

import Modelo.Horario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class VentanaHorarioAviones2 extends JFrame {
    private JTextArea textArea;
    private JButton btnListaVuelos;

    public VentanaHorarioAviones2(List<Horario> vuelos) {
        setTitle("Horario de Aviones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        btnListaVuelos = new JButton("Ver Lista de Vuelos");
        btnListaVuelos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarListaVuelos(vuelos);
            }
        });
        add(btnListaVuelos, BorderLayout.SOUTH);

        mostrarHorarioVuelos(vuelos);

        pack();
        setVisible(true);
    }

    public void mostrarHorarioVuelos(List<Horario> vuelos) {
        StringBuilder sb = new StringBuilder();

        // Obtener la fecha y hora actual
        Date now = new Date();

        // Filtrar y ordenar los vuelos por aeropuerto y hora de salida
        vuelos.stream().filter(vuelo -> vuelo.getFechaSalida().after(now)).sorted((vuelo1, vuelo2) -> {
            int comparacionAeropuerto = vuelo1.getAeropuerto().getNombre()
                    .compareTo(vuelo2.getAeropuerto().getNombre());
            if (comparacionAeropuerto == 0) {
                return vuelo1.getFechaSalida().compareTo(vuelo2.getFechaSalida());
            } else {
                return comparacionAeropuerto;
            }
        }).forEach(vuelo -> sb.append(vuelo.getAeropuerto().getNombre()).append(": ").append(vuelo).append("\n"));

        textArea.setText(sb.toString());
    }

    public void mostrarListaVuelos(List<Horario> vuelos) {
        VentanaListaVuelos ventanaListaVuelos = new VentanaListaVuelos(vuelos);
        ventanaListaVuelos.setVisible(true);
    }
}
