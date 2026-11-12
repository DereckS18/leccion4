package servicios;

import objetos.Tour;

public class OrdenPorDistancia implements CriterioOrdenamiento {
    @Override
    public int compare(Tour a, Tour b) {
        return Double.compare(a.distanciaTotalKm(), b.distanciaTotalKm());
    }

    @Override
    public String descripcion() {
        return "Ordenado por distancia total";
    }
}