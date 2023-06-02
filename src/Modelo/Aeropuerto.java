package Modelo;

import java.util.ArrayList;

import ModeloVista.Avion;

public class Aeropuerto {
	private Coordenadas cords;
	private ArrayList<Vuelo> vuelos;
	private String nombre;
	private int contIds;

	public Aeropuerto(Coordenadas cords, String name) {
		super();
		this.cords = cords;
		this.vuelos = new ArrayList<Vuelo>();
		this.nombre = name;
		this.contIds = 0;
	}

	private void add(Vuelo v) {
		vuelos.add(v);
	}

	public void remove(int id) {
		for (int i = 0; i < vuelos.size(); i++) {
			if (vuelos.get(i).getId() == id) {
				vuelos.remove(i);
				break;
			}
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void crearVuelo(Avion av, String AirP) {
		add(new Vuelo(AirP, this.nombre, av, getContIds()));
	}

	
	public void recibirVuelo(Avion av, String AirP) {
		add(new Vuelo(this.getNombre(), AirP, av, contIds));
	}

	public ArrayList<Vuelo> getVuelos() {
		return vuelos;
	}

	private int getContIds() {
		contIds += 1;
		return contIds;
	}

	public double getX() {
		return this.cords.getX();
	}

	public double getY() {
		return this.cords.getY();
	}

	@Override
	public String toString() {
		return "Aeropuerto:" + getNombre() + "\n\tCordenadas:" + getX() + "," + getY();
	}

	public Coordenadas getCords() {
		return cords;
	}
}
