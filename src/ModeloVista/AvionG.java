package ModeloVista;

import Modelo.Coordenadas;

public abstract class AvionG implements Observable{
	private List<Observer> observers;
        private int id;
        private boolean llegoADestino;
	protected Coordenadas cords;

	public AvionG( int id,Coordenadas cords) {
        super();
	this.id = id;
        this.llegoADestino = false;
	this.cords = cords;
        this.observers = new ArrayList<>();
    }
	public Coordenadas getCords() {
		return cords;
	}
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
	public void llegoADestino() {
        this.llegoADestino = true;
        notifyObservers();
    }

    public boolean haLlegadoADestino() {
        return llegoADestino;
    }

    public String getId() {
        return id;
    }
}
