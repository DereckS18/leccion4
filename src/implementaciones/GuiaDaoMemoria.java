package implementaciones;

import Interfaces.GuiaDao;
import java.util.ArrayList;
import java.util.List;
import objetos.Guia;

public class GuiaDaoMemoria extends DaoMemoriaBase<Guia, String> implements GuiaDao {
    @Override
    protected String idDe(Guia g) {
        return g.getNumeroIdentificacion();
    }

    @Override
    public List<Guia> listarDisponibles() {
        List<Guia> disponibles = new ArrayList<>();
        for (Guia g : almacen.values()) {
            if (g.isDisponible()) {
                disponibles.add(g);
            }
        }
        return disponibles;
    }
}