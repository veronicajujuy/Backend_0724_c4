package dh.backend.test;

import dh.backend.service.FacadeBusqueda;
import dh.backend.service.IBusqueda;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FacadeBusquedaTest {
    IBusqueda busquedaServicioDisponible = new FacadeBusqueda();

    @Test
    void ObtenerHotelyVuelos_paraFechaDeterminada(){
        String respuesta = busquedaServicioDisponible.busqueda(LocalDate.of(2024,04,9),
                LocalDate.of(2024,04,12),"Jujuy","CABA");
        String respuestaEsperada = "Disponible: \n" +
                " vuelo: \n" +
                " fecha salida: 2024-04-09\n" +
                " fecha regreso: 2024-04-12 Origen: Jujuy Destino: CABADisponible: \n" +
                " hotel: \n" +
                " fecha entrada: 2024-04-09\n" +
                " fecha regreso: 2024-04-12 Ciudad: CABA";
        assertEquals(respuestaEsperada, respuesta);
    }

    @Test
    void NoObtenerHotelyVuelos_paraFechaDeterminada(){
        String respuesta = busquedaServicioDisponible.busqueda(LocalDate.of(2024,04,9),
                LocalDate.of(2024,04,12),"Jujuy","Mendoza");
        String respuestaEsperada = "No se encontro el vuelo No se encontro el hotel ";
        assertEquals(respuestaEsperada, respuesta);
    }
}