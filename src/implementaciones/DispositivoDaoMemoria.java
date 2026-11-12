package implementaciones;

import Interfaces.DispositivoDao;
import java.util.ArrayList;
import java.util.List;
import objetos.DispositivoComunicacion;

public class DispositivoDaoMemoria extends DaoMemoriaBase<DispositivoComunicacion, String> implements DispositivoDao {
    @Override
    protected String idDe(DispositivoComunicacion d) {
        return d.getCodigo();
    }

    @Override
    public List<DispositivoComunicacion> listarDisponibles() {
        List<DispositivoComunicacion> disponibles = new ArrayList<>();
        for (DispositivoComunicacion d : almacen.values()) {
            if (d.isDisponible()) {
                disponibles.add(d);
            }
        }
        return disponibles;
    }
}