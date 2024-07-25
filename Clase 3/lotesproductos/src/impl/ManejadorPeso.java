package impl;

import model.Producto;

public class ManejadorPeso extends ManejadorProducto{
    @Override
    public String validarCalidad(Producto producto) {
        if(producto.getPeso()>=1200 && producto.getPeso() <= 1300){
            System.out.println("el producto paso peso");
            return getSiguienteManejador().validarCalidad(producto);
        }
            System.out.println("el producto no paso peso");
            return "El producto no cumple con los estandares de peso";
    }
}
