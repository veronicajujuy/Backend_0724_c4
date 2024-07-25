package test;

import impl.ProxySpotify;
import model.TipoUsuario;
import model.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioSpotifyTest {
    @Test
    @DisplayName("Testear si un usuario premium puede descargar una canción")
    void caso1(){
        //dado
        Usuario usuario = new Usuario("4646646678", TipoUsuario.PREMIUM);
        ProxySpotify proxySpotify = new ProxySpotify();
        String respuestaEsperada = "La descarga esta por comenzar...";
        // cuando
        String respuestaObtenida = proxySpotify.descargar(usuario);
        // entonces
        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    @DisplayName("Testear si un usuario no premium no puede descargar una canción")
    void caso2(){
        //dado
        Usuario usuario = new Usuario("4646646699", TipoUsuario.FREE);
        ProxySpotify proxySpotify = new ProxySpotify();
        String respuestaEsperada = "El usuario debe ser premium para descargar";
        // cuando
        String respuestaObtenida = proxySpotify.descargar(usuario);
        // entonces
        assertEquals(respuestaEsperada, respuestaObtenida);
    }

}