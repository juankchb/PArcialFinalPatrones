package ModeloVista;

import Modelo.Coordenadas;

public abstract class AvionG {

	protected Coordenadas cords;

	public AvionG(Coordenadas cords) {
		super();
		this.cords = cords;
	}

	public Coordenadas getCords() {
		return cords;
	}

}
