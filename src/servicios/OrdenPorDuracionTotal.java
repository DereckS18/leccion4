package servicios;

import objetos.Tour;

public class OrdenPorDuracionTotal implements CriterioOrdenamiento {
    @Override
    public int compare(Tour a, Tour b) {
        return Double.compare(a.duracionTotalMin(), b.duracionTotalMin());
    }

    @Override
    public String descripcion() {
        return "Ordenado por duracion total";
    }
}