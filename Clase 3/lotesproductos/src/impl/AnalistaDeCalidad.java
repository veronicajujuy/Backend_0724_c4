package impl;

import model.Producto;

public class AnalistaDeCalidad {
    private ManejadorProducto inicioCadena;

    public AnalistaDeCalidad() {
        inicioCadena = new ManejadorLote();
        ManejadorProducto peso = new ManejadorPeso();
        ManejadorProducto envase = new ManejadorEnvase();
        // seteo la cadena
        inicioCadena.setSiguienteManejador(peso);
        peso.setSiguienteManejador(envase);
    }

    public String validarCalidad(Producto producto) {
        return inicioCadena.validarCalidad(producto);
    }
}
