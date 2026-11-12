package implementaciones;

import Interfaces.TourDao;
import objetos.Tour;

public class TourDaoMemoria extends DaoMemoriaBase<Tour, String> implements TourDao {
    @Override
    protected String idDe(Tour t) {
        return t.getCodigo();
    }
}