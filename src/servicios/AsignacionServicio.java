package servicios;

import Interfaces.DispositivoDao;
import Interfaces.GuiaDao;
import Interfaces.TourDao;
import java.util.Optional;
import objetos.DispositivoComunicacion;
import objetos.Guia;
import objetos.Tour;

public class AsignacionServicio {
    private TourDao tourDao;
    private DispositivoDao dispositivoDao;
    private GuiaDao guiaDao;

    public AsignacionServicio(TourDao tourDao, DispositivoDao dispositivoDao, GuiaDao guiaDao) {
        this.tourDao = tourDao;
        this.dispositivoDao = dispositivoDao;
        this.guiaDao = guiaDao;
    }

    public ResultadoAsignacion asignar(String codTour, String codDisp, String idGuia) {
        // 1) existe el tour
        Optional<Tour> optTour = tourDao.buscarPorId(codTour);
        if (!optTour.isPresent()) {
            return ResultadoAsignacion.rechazada("No existe el tour con codigo " + codTour);
        }
        Tour tour = optTour.get();

        // 2) existe el dispositivo
        Optional<DispositivoComunicacion> optDisp = dispositivoDao.buscarPorId(codDisp);
        if (!optDisp.isPresent()) {
            return ResultadoAsignacion.rechazada("No existe el dispositivo con codigo " + codDisp);
        }
        DispositivoComunicacion dispositivo = optDisp.get();

        // 3) existe el guia
        Optional<Guia> optGuia = guiaDao.buscarPorId(idGuia);
        if (!optGuia.isPresent()) {
            return ResultadoAsignacion.rechazada("No existe el guia con identificacion " + idGuia);
        }
        Guia guia = optGuia.get();

        // 4) el tour no tiene asignacion
        if (tour.tieneAsignacion()) {
            return ResultadoAsignacion.rechazada("El tour ya tiene recursos asignados");
        }

        // 5) dispositivo disponible
        if (!dispositivo.isDisponible()) {
            return ResultadoAsignacion.rechazada("El dispositivo no esta disponible");
        }

        // 6) guia disponible
        if (!guia.isDisponible()) {
            return ResultadoAsignacion.rechazada("El guia no esta disponible");
        }

        tour.asignarRecursos(dispositivo, guia);
        dispositivo.setDisponible(false);
        guia.setDisponible(false);

        tourDao.actualizar(tour);
        dispositivoDao.actualizar(dispositivo);
        guiaDao.actualizar(guia);

        return ResultadoAsignacion.aceptada("Recursos asignados correctamente al tour " + codTour);
    }
}