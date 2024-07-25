package impl;

import model.Mail;

public class ManejadorSpam extends ManejadorMail{
    @Override
    public String comprobarMail(Mail mail) {
        System.out.println("El mail fue para spam");
        return "El mail fue a spam";
    }
}
