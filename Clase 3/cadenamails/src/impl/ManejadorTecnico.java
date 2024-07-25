package impl;

import model.Mail;

public class ManejadorTecnico extends ManejadorMail{
    @Override
    public String comprobarMail(Mail mail) {
        if(mail.getDestino().equalsIgnoreCase("tecnico@colmena.com") ||
                mail.getTema().equals("tecnico")){
            System.out.println("mail quedo en area tecnica");
            return "El mail lo esta tratando el departamento tecnico";
        }
        System.out.println("El mail no es para area tecnica");
        return getSiguienteManejador().comprobarMail(mail);
    }
}
