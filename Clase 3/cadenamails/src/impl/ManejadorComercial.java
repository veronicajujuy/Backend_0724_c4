package impl;

import model.Mail;

public class ManejadorComercial extends ManejadorMail{
    @Override
    public String comprobarMail(Mail mail) {
        if(mail.getDestino().equalsIgnoreCase("comercial@colmena.com") ||
                mail.getTema().equals("comercial")){
            System.out.println("mail quedo en comercial");
            return "El mail lo esta tratando el departamento comercial";
        }
        System.out.println("El mail no es para comercial");
        return getSiguienteManejador().comprobarMail(mail);
    }
}
