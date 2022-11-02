package main.model;

public abstract class Usuario {

    private String nombre;
    private String appelido;
    private String rol;

    public Usuario() {
    }

    public Usuario(String nombre, String appelido, String rol) {
        this.nombre = nombre;
        this.appelido = appelido;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppelido() {
        return appelido;
    }

    public void setAppelido(String appelido) {
        this.appelido = appelido;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
