package impl;

import model.Mail;

public abstract class ManejadorMail {
    private ManejadorMail siguienteManejador;

    public ManejadorMail getSiguienteManejador() {
        return siguienteManejador;
    }

    public void setSiguienteManejador(ManejadorMail siguienteManejador) {
        this.siguienteManejador = siguienteManejador;
    }
    public abstract String comprobarMail(Mail mail);
}
