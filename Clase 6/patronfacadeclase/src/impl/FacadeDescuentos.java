package impl;

import model.Producto;
import model.Tarjeta;

public class FacadeDescuentos implements IFacadeDescuentos{
    @Override
    public int descuentoTotal(Tarjeta tarjeta, Producto producto, int cantidad) {
        int descuentosAcumulados = 0;
        descuentosAcumulados += ApiTarjeta.descuento(tarjeta);
        descuentosAcumulados += ApiProducto.descuento(producto);
        descuentosAcumulados += ApiCantidad.descuento(cantidad);
        return descuentosAcumulados;
    }
}
