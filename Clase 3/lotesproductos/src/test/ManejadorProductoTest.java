package test;

import impl.AnalistaDeCalidad;
import model.Envasado;
import model.Producto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManejadorProductoTest {

    @Test
    @DisplayName("Chequear que un producto no pase control de peso")
    void caso1(){
        //dado
        Producto producto = new Producto("Lata", 1500, 1100, Envasado.SANO);
        AnalistaDeCalidad analistaDeCalidad = new AnalistaDeCalidad();
        String respuestaEsperada = "El producto no cumple con los estandares de peso";
        //cuando
        String respuestaRecibida = analistaDeCalidad.validarCalidad(producto);
        // entonces
        assertEquals(respuestaEsperada, respuestaRecibida);
    }

    @Test
    @DisplayName("Chequear que un producto no pase control de envase")
    void caso2(){
        //dado
        Producto producto = new Producto("Lata", 1500, 1200, Envasado.DEFECTUOSO);
        AnalistaDeCalidad analistaDeCalidad = new AnalistaDeCalidad();
        String respuestaEsperada = "El producto no cumple con los estandares de envase";
        //cuando
        String respuestaRecibida = analistaDeCalidad.validarCalidad(producto);
        // entonces
        assertEquals(respuestaEsperada, respuestaRecibida);
    }

    @Test
    @DisplayName("Chequear que un producto pase todos los controles")
    void caso3(){
        //dado
        Producto producto = new Producto("Lata", 1500, 1200, Envasado.CASI_SANO);
        AnalistaDeCalidad analistaDeCalidad = new AnalistaDeCalidad();
        String respuestaEsperada = "El producto paso todos los controles";
        //cuando
        String respuestaRecibida = analistaDeCalidad.validarCalidad(producto);
        // entonces
        assertEquals(respuestaEsperada, respuestaRecibida);
    }

}