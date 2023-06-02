package ModeloVista;
import Modelo.Coordenadas;
import ModeloVista.Avion;

public class Avion extends AvionG {

	private int id;

	public Avion(Coordenadas cords, int Id) {
		super(cords);
		this.id = Id;
	}

	public int getId() {
		return id;
	}

	public boolean isAvion(Avion Avi) {
		return Avi.getId() == this.getId() ? true : false;
	}

	public boolean isAvion(int idA) {
		return idA == this.getId() ? true : false;
	}

	public double getX() {
		return cords.getX();
	}

	public double getY() {
		return cords.getY();
	}

	public void setX(double x) {
		this.cords.setX(x);
	}

	public void setY(double y) {
		this.cords.setY(y);
	}

	@Override
	public String toString() {
		return "Avion [id=" + id + "]";
	}

}
