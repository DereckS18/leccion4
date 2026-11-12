package servicios;

import objetos.Tour;

public interface CriterioOrdenamiento {
    int compare(Tour a, Tour b);
    String descripcion();
}