import dao.impl.DaoEnMemoria;
import model.Domicilio;
import model.Paciente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.PacienteService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PacienteServiceTestMemoria {
    PacienteService pacienteService = new PacienteService(new DaoEnMemoria());

    @Test
    @DisplayName("Testear que un paciente fue cargado correctamente con su domicilio")
    void caso1(){
        //Dado
        Paciente paciente = new Paciente("Castro","Maria", "48974646", LocalDate.of(2024,7,15),
                new Domicilio("Falsa",145,"CABA","Buenos Aires"));
        //cuando
        Paciente pacienteDesdeDb = pacienteService.guardarPaciente(paciente);
        // entonces
        assertNotNull(pacienteDesdeDb.getId());
    }

    @Test
    @DisplayName("Testear que un paciente pueda acceder por id")
    void caso2(){
        //Dado
        Integer id = 1;
        //cuando
        Paciente paciente = new Paciente("Juan","Perez", "48974677", LocalDate.of(2024,7,15),
                new Domicilio("Falsa",145,"CABA","Buenos Aires"));
        //cuando
        pacienteService.guardarPaciente(paciente);
        Paciente pacienteDesdeDb = pacienteService.buscarPorId(id);
        // entonces
        assertEquals(id, pacienteDesdeDb.getId());
    }

}