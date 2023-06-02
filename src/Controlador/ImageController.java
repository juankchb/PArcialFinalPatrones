package Controlador;
import java.util.ArrayList;


import Modelo.Aeropuerto;
import Modelo.Coordenadas;
import ModeloVista.Avion;
import vista.ImageView;

public class ImageController {
    private ImageView view;
    private ArrayList<Aeropuerto> airportPositions;
    private ArrayList<Avion> airplanePositions;
    
    
    
    public ImageController(ImageView view, ArrayList<Aeropuerto> airportPositions,
            ArrayList<Avion> airplanePositions) {
        this.view = view;
        this.airportPositions = airportPositions;
        this.airplanePositions = airplanePositions;
        updateView();
    }

    public void updateView() {
        view.drawAirports(airportPositions);
        view.drawAirplanes(airplanePositions);
    }

    public void moveAirplanes(){
        ArrayList<Coordenadas> target = new ArrayList<Coordenadas>();
        for (Aeropuerto a : airportPositions) {
            target.add(new Coordenadas(a.getX(), a.getY()));
        }
        view.moveAirplanes(airplanePositions, target);
        view.drawAirports(airportPositions);
    }

}
