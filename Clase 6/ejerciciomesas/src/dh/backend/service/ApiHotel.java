package dh.backend.service;

import dh.backend.model.Hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ApiHotel {
    private static List<Hotel> hoteles = new ArrayList<>();
    public static String busquedaHoteles(LocalDate fechaEntrada, LocalDate fechaSalida, String ciudad){
        Hotel hotel1 = new Hotel(LocalDate.of(2024,04,05), LocalDate.of(2024,04,9),"CABA");
        Hotel hotel2 = new Hotel(LocalDate.of(2024,04,9), LocalDate.of(2024,04,12),"CABA");
        Hotel hotel3 = new Hotel(LocalDate.of(2024,04,19), LocalDate.of(2024,04,22),"CABA");

        hoteles.add(hotel1);
        hoteles.add(hotel2);
        hoteles.add(hotel3);

        String respuesta = "No se encontro el hotel ";

        for(Hotel hotel: hoteles){
            if(hotel.getFechaEntrada().isEqual(fechaEntrada) && hotel.getFechaSalida().isEqual(fechaSalida)&&
                    hotel.getCiudad().equals(ciudad)){
                respuesta = "Disponible: \n hotel: \n fecha entrada: "+hotel.getFechaEntrada()+"\n fecha regreso: "+ hotel.getFechaSalida()+
                        " Ciudad: "+ hotel.getCiudad();
            }
        }
        System.out.println(respuesta);
        return respuesta;
    }
}
