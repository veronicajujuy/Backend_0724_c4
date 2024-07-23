package clasepresencial;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LiquidacionTest {
    @Test
    @DisplayName("El liquidador debería arrojar un mensaje de error cuando no es posible calcular la liquidación.")
    void caso1(){
        // Dado
        Empleado empleado = new Contratado("Pompilia", "Pompini", "5646466", 120, 7);
        Liquidacion liquidacion = new LiquidacionEfectivo();
        String respuestaEsperada = "La liquidación no pudo ser calculada";
        // cuando

        String respuestaObtenida = liquidacion.liquidarSueldo(empleado);

        // entonces
        assertEquals(respuestaEsperada, respuestaObtenida);

    }

    @Test
    @DisplayName("Debería emitir un documento en papel cuando es un empleado efectivo.")
    void caso2(){
        // Dado
        Empleado empleado = new Efectivo("Martin", "Martini", "5466646",
                400,60, 40 );
        Liquidacion liquidacion = new LiquidacionEfectivo();
        String respuestaEsperada = "La liquidación generada es un documento impreso. Saldo a liquidar: 420.0";
        // cuando

        String respuestaObtenida = liquidacion.liquidarSueldo(empleado);

        // entonces
        assertEquals(respuestaEsperada, respuestaObtenida);

    }

    @Test
    @DisplayName("Debería emitir un documento digital cuando es un empleado contratado.")
    void caso3(){
        // Dado
        Empleado empleado = new Contratado("Pompilia", "Pompini", "5646466", 120, 7);
        Liquidacion liquidacion = new LiquidacionContratado();
        String respuestaEsperada = "La liquidación generada es un documento digital. Saldo a liquidar: 840.0";
        // cuando

        String respuestaObtenida = liquidacion.liquidarSueldo(empleado);

        // entonces
        assertEquals(respuestaEsperada, respuestaObtenida);

    }


}