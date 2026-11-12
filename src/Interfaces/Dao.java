package Interfaces;

import java.util.List;
import java.util.Optional;

public interface Dao<T, K> {
    void guardar(T entidad);
    Optional<T> buscarPorId(K id);
    List<T> listarTodos();
    void actualizar(T entidad);
    boolean eliminar(K id);
}