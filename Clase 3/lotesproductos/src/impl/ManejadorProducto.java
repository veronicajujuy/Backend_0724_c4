package impl;

import model.Producto;

public abstract class ManejadorProducto {
    private ManejadorProducto siguienteManejador;

    public ManejadorProducto getSiguienteManejador() {
        return siguienteManejador;
    }

    public void setSiguienteManejador(ManejadorProducto siguienteManejador) {
        this.siguienteManejador = siguienteManejador;
    }
    public abstract String validarCalidad(Producto producto);
}
