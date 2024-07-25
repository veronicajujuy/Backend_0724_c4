package impl;

import model.Producto;

public class ManejadorLote extends ManejadorProducto{
    @Override
    public String validarCalidad(Producto producto) {
        if(producto.getLote() >= 1000 && producto.getLote() <= 2000){
            System.out.println("el producto paso lote");
            return getSiguienteManejador().validarCalidad(producto);
        }
            System.out.println("el producto no paso lote");
            return "El producto no cumple con los estandares de lote";
    }
}
