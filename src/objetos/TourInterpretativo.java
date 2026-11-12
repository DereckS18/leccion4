package objetos;

public class TourInterpretativo extends Tour {
    private int tiempoActividadesMin;

    public TourInterpretativo(String codigo, String nombre, int tiempoActividadesMin) {
        super(codigo, nombre);
        this.tiempoActividadesMin = tiempoActividadesMin;
    }

    public int getTiempoActividadesMin() {
        return tiempoActividadesMin;
    }

    @Override
    public double duracionTotalMin() {
        return tiempoCaminataAjustadoMin() + tiempoActividadesMin;
    }

    @Override
    public String tipo() {
        return "Interpretativo";
    }
}