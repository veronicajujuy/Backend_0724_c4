package impl;

import model.Producto;
import model.Tarjeta;

public class ApiProducto {
    public static int descuento(Producto producto){
        int descuento = 0;
        if(producto.getTipo().equals("latas")){
            descuento = 10;
        }
        return descuento;
    }
}
