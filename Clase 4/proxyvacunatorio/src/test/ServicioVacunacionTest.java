package test;

import impl.ProxyVacunacion;
import impl.ServicioVacunacion;
import model.Persona;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ServicioVacunacionTest {
    @Test
    @DisplayName("Testear que una persona pueda vacunarse si la fecha de vacunacion corresponde")
    void caso1(){
        // Dado
        Persona persona = new Persona("Juan", "Perez", "456789",
                "Antigripal", LocalDate.of(2024, 07,22));
        ServicioVacunacion proxyVacunacion = new ProxyVacunacion();
        String respuestaEsperada = "La persona Juan Perez fue vacunada el dia: 2024-07-24";
        // Cuando
        String respuestaObtenida = proxyVacunacion.vacunar(persona);
        // entonces

        assertEquals(respuestaEsperada, respuestaObtenida);

    }

    @Test
    @DisplayName("Testear que una persona no pudo vacunarse")
    void caso2(){
        // Dado
        Persona persona = new Persona("Juan", "Perez", "456789",
                "Antigripal", LocalDate.of(2024, 07,25));
        ProxyVacunacion proxyVacunacion = new ProxyVacunacion();
        String respuestaEsperada = "La persona no pudo vacunarse por no cumplir con los requisitos";
        // Cuando
        String respuestaObtenida = proxyVacunacion.vacunar(persona);
        // entonces

        assertEquals(respuestaEsperada, respuestaObtenida);

    }

}