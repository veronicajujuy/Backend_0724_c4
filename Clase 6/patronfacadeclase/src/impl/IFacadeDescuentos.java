package impl;

import model.Producto;
import model.Tarjeta;

public interface IFacadeDescuentos {
    int descuentoTotal(Tarjeta tarjeta, Producto producto, int cantidad);
}
