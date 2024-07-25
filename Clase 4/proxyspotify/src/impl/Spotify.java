package impl;

import model.Usuario;

public class Spotify implements ServicioSpotify{
    @Override
    public String descargar(Usuario usuario) {
        return "La descarga esta por comenzar...";
    }
}
