package objetos;

public class TourRegular extends Tour {

    public TourRegular(String codigo, String nombre) {
        super(codigo, nombre);
    }

    @Override
    public double duracionTotalMin() {
        return tiempoCaminataAjustadoMin();
    }

    @Override
    public String tipo() {
        return "Regular";
    }
}