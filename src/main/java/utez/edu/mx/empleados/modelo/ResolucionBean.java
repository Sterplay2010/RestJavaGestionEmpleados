package utez.edu.mx.empleados.modelo;

public class ResolucionBean {
    private int idResolucion;
    private int idReporte;
    private String fechaHoraResolucion;
    private String comentario;

    public ResolucionBean() {
    }

    public ResolucionBean(int idReporte, String fechaHoraResolucion, String comentario) {
        this.idReporte = idReporte;
        this.fechaHoraResolucion = fechaHoraResolucion;
        this.comentario = comentario;
    }

    public int getIdResolucion() {
        return idResolucion;
    }

    public void setIdResolucion(int idResolucion) {
        this.idResolucion = idResolucion;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public String getFechaHoraResolucion() {
        return fechaHoraResolucion;
    }

    public void setFechaHoraResolucion(String fechaHoraResolucion) {
        this.fechaHoraResolucion = fechaHoraResolucion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
