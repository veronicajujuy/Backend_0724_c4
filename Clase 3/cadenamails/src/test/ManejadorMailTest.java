package test;

import impl.ProcesarMail;
import model.Mail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManejadorMailTest {
    @Test
    @DisplayName("Un correo que corresponde a Tecnico es tratado por el departamento tecnico")
    void caso1 (){
        //dado
        Mail mailIngresado = new Mail("jperez@gmail.com", "tecnico@colmena.com", "problemas con la impresora");
        ProcesarMail procesarMail = new ProcesarMail();
        String respuestaEsperada = "El mail lo esta tratando el departamento tecnico";
        // cuando
        String respuestaObtenida = procesarMail.comprobarMail(mailIngresado);
        // entonces
        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    @DisplayName("Un correo que no corresponde a ningun departamento va a spam")
    void caso2 (){
        //dado
        Mail mailIngresado = new Mail("pedritol@gmail.com", "info@colmena.com", "informacion");
        ProcesarMail procesarMail = new ProcesarMail();
        String respuestaEsperada = "El mail fue a spam";
        // cuando
        String respuestaObtenida = procesarMail.comprobarMail(mailIngresado);
        // entonces
        assertEquals(respuestaEsperada, respuestaObtenida);
    }

}