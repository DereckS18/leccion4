package servicios;

import java.util.ArrayList;
import java.util.List;
import objetos.Tour;

public class Planificador {
    private CriterioOrdenamiento criterio;

    public Planificador(CriterioOrdenamiento criterio) {
        this.criterio = criterio;
    }

    public void setCriterio(CriterioOrdenamiento criterio) {
        this.criterio = criterio;
    }

    public CriterioOrdenamiento getCriterio() {
        return criterio;
    }

    public List<Tour> ordenar(List<Tour> tours) {
        List<Tour> copia = new ArrayList<>(tours);
        for (int i = 0; i < copia.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < copia.size(); j++) {
                if (criterio.compare(copia.get(j), copia.get(min)) < 0) {
                    min = j;
                }
            }
            Tour temp = copia.get(min);
            copia.set(min, copia.get(i));
            copia.set(i, temp);
        }
        return copia;
    }
}