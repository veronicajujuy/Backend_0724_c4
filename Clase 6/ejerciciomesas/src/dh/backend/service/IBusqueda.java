package dh.backend.service;

import java.time.LocalDate;

public interface IBusqueda {
    String busqueda(LocalDate fechaDesde, LocalDate fechaHasta, String origen, String destino);
}
