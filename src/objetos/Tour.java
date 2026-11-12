package objetos;

import java.util.ArrayList;
import java.util.List;

public abstract class Tour {
    private String codigo;
    private String nombre;
    private double factorDificultad = 1.0;
    private List<Sendero> senderos;
    private DispositivoComunicacion dispositivo;
    private Guia guia;

    public Tour(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.senderos = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getFactorDificultad() {
        return factorDificultad;
    }

    public void agregarSendero(Sendero s) {
        senderos.add(s);
    }

    public double distanciaTotalKm() {
        double total = 0;
        for (Sendero s : senderos) {
            if (s.isHabilitado()) {
                total += s.getLongitudKm();
            }
        }
        return total;
    }

    public double tiempoCaminataBaseMin() {
        int total = 0;
        for (Sendero s : senderos) {
            if (s.isHabilitado()) {
                total += s.getTiempoEstimadoMin();
            }
        }
        return total;
    }

    public double tiempoCaminataAjustadoMin() {
        return tiempoCaminataBaseMin() * factorDificultad;
    }

    public abstract double duracionTotalMin();

    public abstract String tipo();

    public void aceptarFactor(double nuevo) {
        this.factorDificultad = nuevo;
    }

    public boolean tieneAsignacion() {
        return dispositivo != null && guia != null;
    }

    public void asignarRecursos(DispositivoComunicacion d, Guia g) {
        this.dispositivo = d;
        this.guia = g;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + ", Nombre: " + nombre + ", Tipo: " + tipo()
                + ", Distancia: " + distanciaTotalKm() + " km, Duracion: "
                + duracionTotalMin() + " min";
    }
}