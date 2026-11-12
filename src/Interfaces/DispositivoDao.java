package Interfaces;

import java.util.List;
import objetos.DispositivoComunicacion;

public interface DispositivoDao extends Dao<DispositivoComunicacion, String> {
    List<DispositivoComunicacion> listarDisponibles();
}