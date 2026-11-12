package objetos;

public class Guia {
    private String numeroIdentificacion;
    private String nombre;
    private boolean disponible = true;

    public Guia(String numeroIdentificacion, String nombre) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean d) {
        this.disponible = d;
    }
}