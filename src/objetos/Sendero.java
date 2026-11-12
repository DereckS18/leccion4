package objetos;

public class Sendero {
    private String nombre;
    private double longitudKm;
    private int tiempoEstimadoMin;
    private boolean habilitado = true;

    public Sendero(String nombre, double longitudKm, int tiempoEstimadoMin) {
        this.nombre = nombre;
        this.longitudKm = longitudKm;
        this.tiempoEstimadoMin = tiempoEstimadoMin;
    }

    public double getLongitudKm() {
        return longitudKm;
    }

    public int getTiempoEstimadoMin() {
        return tiempoEstimadoMin;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean h) {
        this.habilitado = h;
    }
}