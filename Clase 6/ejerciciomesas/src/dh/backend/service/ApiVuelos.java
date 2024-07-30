package dh.backend.service;

import dh.backend.model.Vuelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ApiVuelos {
    private static List<Vuelo> vuelos = new ArrayList<>();
    public static String busquedaVuelo(LocalDate fechaSalida, LocalDate fechaRegreso, String origen, String destino){

        Vuelo vuelo1 = new Vuelo(LocalDate.of(2024,04,05), LocalDate.of(2024,04,9),"Jujuy","CABA");
        Vuelo vuelo2 = new Vuelo(LocalDate.of(2024,04,9), LocalDate.of(2024,04,12),"Jujuy","CABA");
        Vuelo vuelo3 = new Vuelo(LocalDate.of(2024,04,19), LocalDate.of(2024,04,22),"Jujuy","CABA");

        vuelos.add(vuelo1);
        vuelos.add(vuelo2);
        vuelos.add(vuelo3);

        String respuesta = "No se encontro el vuelo ";

        for(Vuelo vuelo: vuelos){
            if(vuelo.getFechaSalida().isEqual(fechaSalida) && vuelo.getFechaRegreso().isEqual(fechaRegreso)&&
                    vuelo.getOrigen().equals(origen)&&vuelo.getDestino().equals(destino)){
                respuesta = "Disponible: \n vuelo: \n fecha salida: "+vuelo.getFechaSalida()+"\n fecha regreso: "+ vuelo.getFechaRegreso()+
                        " Origen: "+vuelo.getOrigen()+" Destino: "+vuelo.getDestino();
            }
        }
        System.out.println(respuesta);
        return respuesta;
    }
}
