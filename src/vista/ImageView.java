package vista;

import javax.swing.*;
import java.awt.*;

import Modelo.Aeropuerto;
import Modelo.Coordenadas;
import ModeloVista.Avion;

import java.util.ArrayList;

public class ImageView extends JFrame {
    private Image backgroundImage;
    private ImageIcon airplaneIcon = new ImageIcon(
            "C:\\Users\\david\\Downloads\\radarSebas\\radarSebas\\src\\Info\\av.png");
    private ImageIcon airportIcon = new ImageIcon(
            "C:\\Users\\david\\Downloads\\radarSebas\\radarSebas\\src\\Info\\ubi.png");

    public ImageView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Abre la ventana en pantalla completa
        setTitle("Radar");
        setLayout(new GridLayout(1, 2));

        // Carga la imagen de fondo
        backgroundImage = new ImageIcon("C:\\Users\\david\\Downloads\\radarSebas\\radarSebas\\src\\Info\\fondo.jpeg")
                .getImage();

        pack();
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Dibuja la imagen de fondo
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
    }

    public void drawAirportsC(ArrayList<Coordenadas> airportPositions) {
        Graphics g = getGraphics();
        System.out.println("---------------------------------------");
        /*
         * for (Aeropuerto aeropuerto : airportPositions) {
         * System.out.println(aeropuerto.toString());
         * }
         */
        for (Coordenadas position : airportPositions) {
            // Redimensiona la imagen del aeropuerto al tamaño deseado
            Image resizedAirportImage = airportIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);

            // Crea un nuevo ImageIcon con la imagen redimensionada
            ImageIcon resizedAirportIcon = new ImageIcon(resizedAirportImage);

            // Calcula las coordenadas para posicionar la imagen
            int x = (int) ((int) position.getX()) - resizedAirportIcon.getIconWidth() / 2;
            int y = (int) ((int) position.getY()) - resizedAirportIcon.getIconHeight() / 2;

            // Dibuja la imagen del aeropuerto en las coordenadas especificadas
            resizedAirportIcon.paintIcon(this, g, x, y);
            System.out.println(position.toString());
        }
    }

    public void drawAirports(ArrayList<Aeropuerto> airportPositions) {
        Graphics g = getGraphics();
        System.out.println("---------------------------------------");
        /*
         * for (Aeropuerto aeropuerto : airportPositions) {
         * System.out.println(aeropuerto.toString());
         * }
         */
        for (Aeropuerto position : airportPositions) {
            // Redimensiona la imagen del aeropuerto al tamaño deseado
            Image resizedAirportImage = airportIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);

            // Crea un nuevo ImageIcon con la imagen redimensionada
            ImageIcon resizedAirportIcon = new ImageIcon(resizedAirportImage);

            // Calcula las coordenadas para posicionar la imagen
            int x = (int) ((int) position.getX()) - resizedAirportIcon.getIconWidth() / 2;
            int y = (int) ((int) position.getY()) - resizedAirportIcon.getIconHeight() / 2;

            // Dibuja la imagen del aeropuerto en las coordenadas especificadas
            resizedAirportIcon.paintIcon(this, g, x, y);
            System.out.println(position.toString());
        }
    }

    public void drawAirplanes(ArrayList<Avion> airplanePositions) {
        Graphics g = getGraphics();

        for (Avion position : airplanePositions) {
            // Redimensiona la imagen del avión al tamaño deseado
            Image resizedAirplaneImage = airplaneIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);

            // Crea un nuevo ImageIcon con la imagen redimensionada
            ImageIcon resizedAirplaneIcon = new ImageIcon(resizedAirplaneImage);

            // Calcula las coordenadas para posicionar la imagen
            int x = (int) (position.getX() - resizedAirplaneIcon.getIconWidth() / 2);
            int y = (int) (position.getY() - resizedAirplaneIcon.getIconHeight() / 2);

            // Dibuja la imagen del avión en las coordenadas especificadas
            resizedAirplaneIcon.paintIcon(this, g, x, y);
        }
    }

    public void moveAirplanes(ArrayList<Avion> airplanePositions, ArrayList<Coordenadas> targetPositions) {
        Graphics g = getGraphics();
        g.setColor(Color.BLUE);

        // Verifica que la cantidad de posiciones de aviones y de objetivos sea la misma
        if (airplanePositions.size() != targetPositions.size()) {
            System.out.println("Aviones:" + airplanePositions.size());
            System.out.println("Aeropuertos:" + targetPositions.size());
            System.out.println("La cantidad de posiciones de aviones y de objetivos no coincide");
            return;
        }

        for (int i = 0; i < airplanePositions.size(); i++) {
            Avion currentPosition = airplanePositions.get(i);
            Coordenadas targetPosition = targetPositions.get(i);

            // Calcula la dirección del movimiento
            double dx = targetPosition.x - currentPosition.getX();
            double dy = targetPosition.y - currentPosition.getY();

            // Calcula la distancia total del movimiento
            double distance = Math.sqrt(dx * dx + dy * dy);

            // Calcula las velocidades en los ejes x e y
            double speedX = dx / distance;
            double speedY = dy / distance;

            // Calcula la cantidad de pixeles a mover en cada iteración
            double stepSize = 1.0;

            // Mueve el avión hacia el objetivo en pequeños pasos
            while (distance > stepSize) {
                currentPosition.setX((speedX * stepSize) + currentPosition.getX());
                currentPosition.setY((speedY * stepSize) + currentPosition.getY());
                distance -= stepSize;

                // Borra los aviones anteriores
                repaint();

                // Dibuja los aviones en las nuevas posiciones
                drawAirplanes(airplanePositions);
                drawAirportsC(targetPositions);
                // Espera un breve momento para simular el movimiento
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Actualiza la posición final del avión
            currentPosition.setX(targetPosition.x);
            currentPosition.setY(targetPosition.y);

            // Borra los aviones anteriores
            repaint();

            // Dibuja los aviones en las nuevas posiciones finales
            drawAirplanes(airplanePositions);
            // drawAirports(targetPositions);
        }
    }

}
