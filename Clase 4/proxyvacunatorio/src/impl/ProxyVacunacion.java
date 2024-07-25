package impl;

import model.Persona;

import java.time.LocalDate;

public class ProxyVacunacion implements ServicioVacunacion{
    private Vacunacion vacunacion;

    public ProxyVacunacion() {
        vacunacion = new Vacunacion();
    }

    @Override
    public String vacunar(Persona persona) {
        if(persona.getFechaVacunacion().isBefore(LocalDate.now()) ||
                persona.getFechaVacunacion().isEqual(LocalDate.now()))
            return vacunacion.vacunar(persona);
        return "La persona no pudo vacunarse por no cumplir con los requisitos";
    }
}
