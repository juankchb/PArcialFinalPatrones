package Controlador;

import java.util.List;
import java.util.Random;
import Modelo.Horario;
import vista.VentanaHorarioAviones2;
import java.util.ArrayList;
import java.util.Date;
import Modelo.Aeropuerto;
import Modelo.Coordenadas;
import Modelo.LectorFicheros;
import Modelo.Vuelo;
import ModeloVista.Avion;
import vista.VentanaListaVuelos;
import vista.ImageView;

public class controlador {

	private ArrayList<Aeropuerto> aeropuertos;
	private ArrayList<Avion> aviones;
	private ImageController ImageC;
	private LectorFicheros lf = new LectorFicheros();
	private VentanaHorarioAviones2 vistaHorarioAviones;
	private List<Horario> vuelos;

	public controlador() {
		super();
		this.aeropuertos = crearAeropuertos();
		this.aviones = new ArrayList<Avion>();

		llenarAviones();
		AsignacionVuelos();
		this.ImageC = new ImageController(new ImageView(), aeropuertos,
				aviones);
		// Prueba();
		this.vuelos=obtenerVuelosEjemplo();
		this.vistaHorarioAviones = new VentanaHorarioAviones2(this.vuelos);

	}

	private void llenarAviones() {
		Random r = new Random();

		int xx = r.nextInt(1400);
		int yy = r.nextInt(800);
		for (int index = 0; index < 8; index++) {
			xx = r.nextInt(1400);
			yy = r.nextInt(800);
			double x = Double.valueOf(xx);
			double y = Double.valueOf(yy);
			aviones.add(new Avion(new Coordenadas(x, y), index));
		}
	}

	public void AsignacionVuelos() {
		for (int index = 0; index < aeropuertos.size(); index++) {
			if (index == aeropuertos.size() - 1) {
				Aeropuerto a = aeropuertos.get(index);
				a.crearVuelo(aviones.get(index), aeropuertos.get(0).getNombre());
				aeropuertos.set(index, a);
				a = aeropuertos.get(0);
				a.recibirVuelo(aviones.get(index), aeropuertos.get(aeropuertos.size() - 1).getNombre());
				aeropuertos.set(0, a);
			} else {
				Aeropuerto a = aeropuertos.get(index);
				a.crearVuelo(aviones.get(index), aeropuertos.get(index).getNombre());
				aeropuertos.set(index, a);
				a = aeropuertos.get(index + 1);
				int i = index + 1;
				a.recibirVuelo(aviones.get(index), aeropuertos.get(i).getNombre());
				aeropuertos.set(index + 1, a);
			}

		}
	}

	public void work() {
		mostrarHorarioAviones();
		ImageC.moveAirplanes();
	}

	private ArrayList<Aeropuerto> crearAeropuertos() {
		ArrayList<Aeropuerto> As = new ArrayList<Aeropuerto>();
		As.addAll(lf.ObtenerDatosArchivoAero(
				"C:\\Users\\david\\Downloads\\radarSebas\\radarSebas\\src\\Info\\aeropuertos.txt"));
		// System.out.println(As.get(0).toString());
		return As;
	}

	@SuppressWarnings("deprecation")
	private List<Horario> obtenerVuelosEjemplo() {
		// Crear una lista de vuelos de ejemplo utilizando la clase Horario
		List<Horario> vue = new ArrayList<>();
		for (Aeropuerto A : aeropuertos) {
			ArrayList<Vuelo> vu = new ArrayList<Vuelo>(A.getVuelos());
			for (Vuelo B : vu) {
				vue.add(B.mostrarHorario());
			}
		}

		return vuelos;
	}

	public void mostrarHorarioAviones() {
		List<Horario> vuelos = obtenerVuelosEjemplo();
		VentanaHorarioAviones2 ventanaHorarioAviones = new VentanaHorarioAviones2(vuelos);
	}

	public void mostrarListaVuelos() {
		List<Horario> vuelos = obtenerVuelosEjemplo();
		VentanaListaVuelos ventanaListaVuelos = new VentanaListaVuelos(vuelos);
	}
}
