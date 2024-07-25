package impl;

import model.Envasado;
import model.Producto;

public class ManejadorEnvase extends ManejadorProducto {
    @Override
    public String validarCalidad(Producto producto) {
        if(producto.getEnvasado().equals(Envasado.SANO) || producto.getEnvasado().equals(Envasado.CASI_SANO)){
            System.out.println("el producto paso envasado");
            return "El producto paso todos los controles";
        }
            System.out.println("el producto no paso envasado");
            return "El producto no cumple con los estandares de envase";
    }
}
