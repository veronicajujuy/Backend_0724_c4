package clase;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private List<Persona> personas;

    public Grupo() {
        this.personas = new ArrayList<>();
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public void agregarPersona(Persona persona){
        if(persona.chequearEdad() && persona.chequearLongitudNombre()
                && persona.chequearNombreEntreAz() && persona.chequearEdadEntre0y120())
            personas.add(persona);
        else
            System.out.println("no se pudo agregar al grupo");
    }


}
