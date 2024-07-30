package test;

import impl.FacadeDescuentos;
import impl.IFacadeDescuentos;
import model.Producto;
import model.Tarjeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IFacadeDescuentosTest {
    @Test
    @DisplayName("Testeamos que se puedan aplicar todos los descuentos")
    void caso1(){
        //dado
        Tarjeta tarjeta = new Tarjeta("4567", "Star Bank");
        Producto producto = new Producto("Pepsi", "latas");
        int cantidad = 20;
        // cuando
        IFacadeDescuentos facadeDescuentos = new FacadeDescuentos();
        int descuentoObtenido = facadeDescuentos.descuentoTotal(tarjeta, producto, cantidad);
        // entonces
        assertEquals(45, descuentoObtenido);
    }

    @Test
    @DisplayName("Testeamos que no se aplique ningun descuento")
    void caso2(){
        //dado
        Tarjeta tarjeta = new Tarjeta("5897", "Patagonia");
        Producto producto = new Producto("Papas", "papas");
        int cantidad = 10;
        // cuando
        IFacadeDescuentos facadeDescuentos = new FacadeDescuentos();
        int descuentoObtenido = facadeDescuentos.descuentoTotal(tarjeta, producto, cantidad);
        // entonces
        assertEquals(0, descuentoObtenido);
    }

}