package dh.backend.model;

import java.time.LocalDate;

public class Vuelo {
    private LocalDate fechaSalida;
    private LocalDate fechaRegreso;
    private String origen;
    private String destino;

    public Vuelo(LocalDate fechaSalida, LocalDate fechaRegreso, String origen, String destino) {
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        this.origen = origen;
        this.destino = destino;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public LocalDate getFechaRegreso() {
        return fechaRegreso;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }
}
