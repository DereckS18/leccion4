package implementaciones;

import Interfaces.Dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class DaoMemoriaBase<T, K> implements Dao<T, K> {
    protected Map<K, T> almacen = new HashMap<>();

    protected abstract K idDe(T entidad);

    @Override
    public void guardar(T entidad) {
        almacen.put(idDe(entidad), entidad);
    }

    @Override
    public Optional<T> buscarPorId(K id) {
        return Optional.ofNullable(almacen.get(id));
    }

    @Override
    public List<T> listarTodos() {
        return new ArrayList<>(almacen.values());
    }

    @Override
    public void actualizar(T entidad) {
        K id = idDe(entidad);
        if (almacen.containsKey(id)) {
            almacen.put(id, entidad);
        }
    }

    @Override
    public boolean eliminar(K id) {
        if (almacen.containsKey(id)) {
            almacen.remove(id);
            return true;
        }
        return false;
    }
}