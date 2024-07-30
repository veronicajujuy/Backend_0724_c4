package impl;

import model.Tarjeta;

public class ApiCantidad {
    public static int descuento(int cantidad){
        int descuento = 0;
        if(cantidad > 12){
            descuento = 15;
        }
        return descuento;
    }
}
