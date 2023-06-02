package Modelo;

import java.time.LocalDateTime;
import ModeloVista.Avion;

public class Vuelo implements Observer{
	private Horario horario;
	private String Aeropuertollegada;
	private String Aeropuertosalida;
	private Avion avion;
	private String estado;
	private int id;
	private List<Avion> listaVuelos;

	public Vuelo(String aeropuertollegada, String aeropuertosalida, Avion av, int Id, List<Avion> listaVuelos) {
		super();

		LocalDateTime fechaActual = LocalDateTime.now();
		this.horario = generarHorario(fechaActual.getYear(), fechaActual.getMonth().getValue(),
				fechaActual.getDayOfMonth(),
				fechaActual.getHour(), fechaActual.getMinute());

		this.Aeropuertollegada = aeropuertollegada;
		this.Aeropuertosalida = aeropuertosalida;
		this.avion = av;
		this.estado = "Vuelo creado";
		this.id = Id;
		this.listaVuelos = listaVuelos;
	}

	private Horario generarHorario(int year, int month, int day, int hr, int min) {
		return new Horario(year, month, day, hr, min, year, month, day, hr, min);
	}

	public Horario mostrarHorario() {
		this.horario.toString();
		return this.horario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAeropuertollegada() {
		return Aeropuertollegada;
	}

	public String getAeropuertosalida() {
		return Aeropuertosalida;
	}

	public Avion getAvion() {
		return avion;
	}

	public int getId() {
		return id;
	}
	public void update() {
        if (avion.haLlegadoADestino()) {
            System.out.println("El avión con código de vuelo " + avion.getCodigoVuelo() + " ha llegado a su destino.");
            listaVuelos.remove(avion);
        }
    }
}
