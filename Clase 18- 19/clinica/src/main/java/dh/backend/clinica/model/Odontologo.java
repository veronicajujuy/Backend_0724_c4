package dh.backend.clinica.model;
import dh.backend.clinica.utils.GsonProvider;

public class Odontologo {
    private Integer id;
    private String nroMatricula;
    private String apellido;
    private String nombre;

    public Odontologo() {
    }

    public Odontologo(Integer id, String nroMatricula, String apellido, String nombre) {
        this.id = id;
        this.nroMatricula = nroMatricula;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public Odontologo(String nroMatricula, String apellido, String nombre) {
        this.nroMatricula = nroMatricula;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNroMatricula() {
        return nroMatricula;
    }

    public void setNroMatricula(String nroMatricula) {
        this.nroMatricula = nroMatricula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {

        return GsonProvider.getGson().toJson(this);
    }
}
