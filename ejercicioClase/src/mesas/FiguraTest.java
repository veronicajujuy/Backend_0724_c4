package mesas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FiguraTest {

    //El cuadrado y el circulo proporcionan areas correctas
    //Si creamos un cuadrado y un circulo con medidas = 0 no deberia poder calcular el area

    @Test
    @DisplayName("El cuadrado proporciona area correcta")
    void areaCuadrado(){
        // Dado
        Figura figura1 = new Cuadrado(10.0);
        String respuestaEsperada = "El área del cuadrado es 100.0 unidades";
        // Cuando se realiza el proceso
        String respuesta = figura1.calculoArea();

        // Entonces
        assertEquals(respuestaEsperada, respuesta);

    }

    @Test
    @DisplayName("El circulo proporciona area correcta")
    void areaCirculo(){
        // Dado
        Figura figura1 = new Circulo(10.0);
        String respuestaEsperada = "El área del círculo es 314.16 unidades";
        // Cuando se realiza el proceso
        String respuesta = figura1.calculoArea();

        // Entonces
        assertEquals(respuestaEsperada, respuesta);

    }

    @Test
    @DisplayName("No se puede calcular un area igual a cero")
    void areaCirculoCero(){
        // Dado
        Figura figura1 = new Circulo(0.0);
        String respuestaEsperada = "El valor del radio o lado debe ser mayor que cero";
        // Cuando se realiza el proceso
        String respuesta = figura1.calculoArea();

        // Entonces
        assertEquals(respuestaEsperada, respuesta);

    }

}