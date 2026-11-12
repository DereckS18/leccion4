package objetos;

public class DispositivoComunicacion {
    private String codigo;
    private String descripcion;
    private boolean disponible = true;

    public DispositivoComunicacion(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean d) {
        this.disponible = d;
    }
}