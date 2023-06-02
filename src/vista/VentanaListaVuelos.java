package vista;

import Modelo.Horario;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class VentanaListaVuelos extends JFrame {
    private JTextArea textArea;

    public VentanaListaVuelos(List<Horario> vuelos) {
        setTitle("Lista de Vuelos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        mostrarListaVuelos(vuelos);

        pack();
        setVisible(true);
    }

    public void mostrarListaVuelos(List<Horario> vuelos) {
        StringBuilder sb = new StringBuilder();

        for (Horario vuelo : vuelos) {
            sb.append(vuelo.toString()).append("\n");
        }

        textArea.setText(sb.toString());
    }
}
