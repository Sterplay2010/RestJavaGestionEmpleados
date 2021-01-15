package utez.edu.mx.empleados.modelo;

public class EmpleadoBean {
    private int id;
    private String nombreCompleto;
    private String domicilio;
    private String sexo;
    private String fechaNacimiento;
    private String email;
    private String telefono;
    private String contrasenia;
    private String area;
    private int idRol;

    public EmpleadoBean() {
    }

    public EmpleadoBean(int id, String nombreCompleto, String domicilio, String sexo, String fechaNacimiento, String email, String telefono, String contrasenia, String area, int idRol) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.domicilio = domicilio;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.area = area;
        this.idRol = idRol;
    }

    public EmpleadoBean(String nombreCompleto, String domicilio, String sexo, String fechaNacimiento, String email, String telefono, String contrasenia, String area, int idRol) {
        this.nombreCompleto = nombreCompleto;
        this.domicilio = domicilio;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.area = area;
        this.idRol = idRol;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
}
