package main.model;

import java.util.Date;

public class Paciente extends Usuario{

    private String domicilio;
    private String DNI;
    private Date fechaAlta;

    public Paciente(String nombre, String appelido, String rol, String domicilio, String DNI, Date fechaAlta) {
        super(nombre, appelido, rol);
        this.domicilio = domicilio;
        this.DNI = DNI;
        this.fechaAlta = fechaAlta;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}
