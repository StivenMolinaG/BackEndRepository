package main.model;

public class Odontologo extends Usuario{

    private String matricula;

    public Odontologo(String nombre, String appelido, String rol, String matricula) {
        super(nombre, appelido, rol);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
