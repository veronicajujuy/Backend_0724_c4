package model;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private String vacuna;
    private LocalDate fechaVacunacion;

    public Persona(String nombre, String apellido, String dni, String vacuna, LocalDate fechaVacunacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.vacuna = vacuna;
        this.fechaVacunacion = fechaVacunacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }

    public LocalDate getFechaVacunacion() {
        return fechaVacunacion;
    }

    public void setFechaVacunacion(LocalDate fechaVacunacion) {
        this.fechaVacunacion = fechaVacunacion;
    }
}
