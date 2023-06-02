package Modelo;

public class VueloCreado implements EstadoVuelo {
    public String estado;

    @Override
    public String iniciar() {
        return "Iniciado";
    }

    @Override
    public void cancelar() {
        // return "cancelado";
    }

    @Override
    public void finalizar() {
    }

}
