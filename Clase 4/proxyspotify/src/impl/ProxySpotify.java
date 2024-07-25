package impl;

import model.TipoUsuario;
import model.Usuario;

public class ProxySpotify implements ServicioSpotify{
    private Spotify spotify;

    public ProxySpotify() {
        spotify = new Spotify();
    }

    @Override
    public String descargar(Usuario usuario) {
        if(usuario.getTipo().equals(TipoUsuario.PREMIUM)){
            return spotify.descargar(usuario);
        } else {

            return "El usuario debe ser premium para descargar";
        }
    }
}
