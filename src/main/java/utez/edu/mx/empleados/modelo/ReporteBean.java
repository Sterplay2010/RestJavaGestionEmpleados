package utez.edu.mx.empleados.modelo;

public class ReporteBean {
    private int idReporte;
    private String fechaHora;
    private String descripcion;
    private int idEmpleado;
    private int estatus;

    public ReporteBean() {
    }

    public ReporteBean(int idReporte, String fechaHora, String descripcion, int idEmpleado, int estatus) {
        this.idReporte = idReporte;
        this.fechaHora = fechaHora;
        this.descripcion = descripcion;
        this.idEmpleado = idEmpleado;
        this.estatus = estatus;
    }

    public ReporteBean(String descripcion, int idEmpleado, int estatus) {
        this.descripcion = descripcion;
        this.idEmpleado = idEmpleado;
        this.estatus = estatus;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
}
