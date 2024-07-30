package impl;

import model.Tarjeta;

public class ApiTarjeta {
    public static int descuento(Tarjeta tarjeta){
        int descuento = 0;
        if(tarjeta.getBanco().equals("Star Bank")){
            descuento = 20;
        }
        return descuento;
    }
}
