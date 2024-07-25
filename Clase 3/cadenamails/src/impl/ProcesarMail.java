package impl;

import model.Mail;

public class ProcesarMail {
    private ManejadorMail iniciarCadena;

    public ProcesarMail() {
        iniciarCadena = new ManejadorComercial();
        ManejadorMail tecnico = new ManejadorTecnico();
        ManejadorMail gerencial = new ManejadorGerencial();
        ManejadorMail spam = new ManejadorSpam();

        iniciarCadena.setSiguienteManejador(tecnico);
        tecnico.setSiguienteManejador(gerencial);
        gerencial.setSiguienteManejador(spam);
    }

    public String comprobarMail(Mail mail) {
        return iniciarCadena.comprobarMail(mail);
    }
}
