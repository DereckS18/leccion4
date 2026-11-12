package servicios;

public class ResultadoAsignacion {
    private boolean aceptada;
    private String detalle;

    private ResultadoAsignacion(boolean aceptada, String detalle) {
        this.aceptada = aceptada;
        this.detalle = detalle;
    }

    public static ResultadoAsignacion aceptada(String d) {
        return new ResultadoAsignacion(true, d);
    }

    public static ResultadoAsignacion rechazada(String d) {
        return new ResultadoAsignacion(false, d);
    }

    public boolean isAceptada() {
        return aceptada;
    }

    public String getDetalle() {
        return detalle;
    }
}