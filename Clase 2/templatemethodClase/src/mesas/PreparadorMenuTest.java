package mesas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PreparadorMenuTest {

    @Test
    @DisplayName("Testear menu clasico")
    void caso1(){
        // dado
        Menu menu = new Menu(1500,0,0,0);
        PreparadorMenu preparadorMenu = new PreparadorMenuClasico();
        String respuestaEsperada = "Preparando el menu clasico. Total: 1500.0";
        // cuando
        String respuestaObtenida = preparadorMenu.prepararMenu(menu);
        // entonces
        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    @DisplayName("Testear menu vegetariano")
    void caso2(){
        // dado
        Menu menu = new Menu(1500,0,3,2);
        PreparadorMenu preparadorMenu = new PreparadorMenuVeggie();
        String respuestaEsperada = "Armando menu Vegetariano. Total: 1549.0";
        // cuando
        String respuestaObtenida = preparadorMenu.prepararMenu(menu);
        // entonces
        assertEquals(respuestaEsperada, respuestaObtenida);
    }

}