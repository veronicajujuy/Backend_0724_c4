package test;

import impl.ComputadoraFactory;
import model.Computadora;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputadoraFactoryTest {
    @Test
    @DisplayName("Testear que si se crean varias computadoras del mismo tipo, el contador deberia devolver 1")
    void caso1(){
        //dado
        Computadora computadora1 = ComputadoraFactory.getComputadora("Windows", 2, 128);
        Computadora computadora2 = ComputadoraFactory.getComputadora("Windows", 2, 128);
        Computadora computadora3 = ComputadoraFactory.getComputadora("Windows", 2, 128);
        Computadora computadora4 = ComputadoraFactory.getComputadora("Windows", 2, 128);
        Computadora computadora5 = ComputadoraFactory.getComputadora("Windows", 2, 128);
        // cuando
        int contador = Computadora.getContador();
        // entonces
        assertEquals(1, contador);
    }

    @Test
    @DisplayName("Testear que si se crean varias computadoras diferentes, el contador deberia devolver " +
            "la cantidad de computadoras diferentes")
    void caso2(){
        //dado
        Computadora computadora1 = ComputadoraFactory.getComputadora("Windows", 2, 128);
        Computadora computadora2 = ComputadoraFactory.getComputadora("Windows2", 8, 250);
        Computadora computadora3 = ComputadoraFactory.getComputadora("Windows2", 8, 250);
        Computadora computadora4 = ComputadoraFactory.getComputadora("Mac16", 16, 500);
        Computadora computadora5 = ComputadoraFactory.getComputadora("Mac16", 16, 500);
        Computadora computadora6 = ComputadoraFactory.getComputadora("Windows", 2, 128);
        Computadora computadora7 = ComputadoraFactory.getComputadora("Windows", 2, 128);
        Computadora computadora8 = ComputadoraFactory.getComputadora("Windows", 32, 128);
        // cuando
        int contador = Computadora.getContador();
        // entonces
        assertEquals(4, contador);
    }
}