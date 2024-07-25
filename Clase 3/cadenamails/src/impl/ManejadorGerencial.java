package impl;

import model.Mail;

public class ManejadorGerencial extends ManejadorMail{
    @Override
    public String comprobarMail(Mail mail) {
        if(mail.getDestino().equalsIgnoreCase("gerencia@colmena.com") ||
        mail.getTema().equals("gerencia")){
            System.out.println("mail quedo en gerencia");
            return "El mail lo esta tratando el departamento gerencial";
        }
        System.out.println("El mail no es para gerencia");
        return getSiguienteManejador().comprobarMail(mail);
    }
}
