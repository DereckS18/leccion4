package Interfaces;

import java.util.List;
import objetos.Guia;

public interface GuiaDao extends Dao<Guia, String> {
    List<Guia> listarDisponibles();
}