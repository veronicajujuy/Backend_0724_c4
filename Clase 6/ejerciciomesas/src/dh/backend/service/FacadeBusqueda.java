package dh.backend.service;
import java.time.LocalDate;

public class FacadeBusqueda implements IBusqueda{

    @Override
    public String busqueda(LocalDate fechaDesde, LocalDate fechaHasta, String origen, String destino) {
        String respuesta = null;
        respuesta = ApiVuelos.busquedaVuelo(fechaDesde,fechaHasta, origen, destino);
        respuesta += ApiHotel.busquedaHoteles(fechaDesde,fechaHasta, destino);
        System.out.println(respuesta);
        return respuesta;
    }
}
