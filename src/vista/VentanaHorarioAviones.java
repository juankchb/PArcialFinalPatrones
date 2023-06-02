package vista;

import Modelo.Horario;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaHorarioAviones extends JFrame {
    private JTextArea horarioAviones;

    public VentanaHorarioAviones(List<Horario> vuelos) {
        // Configurar la ventana
        setTitle("Horario de Aviones");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el área de texto para mostrar el horario de los aviones
        horarioAviones = new JTextArea();
        horarioAviones.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(horarioAviones);

        // Agregar el área de texto al panel de contenido de la ventana

        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Mostrar los vuelos en el horario de aviones
        mostrarVuelos(vuelos);

        // Mostrar la ventana
        setVisible(true);
    }

    public void mostrarVuelos(List<Horario> vuelos) {
        // Limpiar el área de texto del horario de aviones
        horarioAviones.setText("");

        // Mostrar los vuelos en el horario de aviones
        for (Horario vuelo : vuelos) {
            horarioAviones.append(vuelo.getFechaSalida() + " - " + vuelo.getFechaLlegada() + "\n");
        }
    }

}
