package dh.backend.clinica;


import dh.backend.clinica.entity.Domicilio;
import dh.backend.clinica.entity.Paciente;
import dh.backend.clinica.service.impl.PacienteService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@Transactional
class PacienteServiceTest {
    static final Logger logger = LoggerFactory.getLogger(PacienteServiceTest.class);
    @Autowired
    PacienteService pacienteService;
    Paciente paciente;
    Paciente pacienteDesdeDb;

    @BeforeEach
    void cargarDatos(){
        Domicilio domicilio = new Domicilio(null,"Falsa",145,"CABA","Buenos Aires");
        paciente = new Paciente();
        paciente.setApellido("Castro");
        paciente.setNombre("Maria");
        paciente.setDni("48974646");
        paciente.setFechaIngreso(LocalDate.of(2024,7,15));
        paciente.setDomicilio(domicilio);
        pacienteDesdeDb = pacienteService.guardarPaciente(paciente);
    }

    @Test
    @DisplayName("Testear que un paciente fue cargado correctamente con su domicilio")
    void caso1(){
        assertNotNull(pacienteDesdeDb.getId());
    }

    @Test
    @DisplayName("Testear que un paciente pueda acceder por id")
    void caso2(){
        //Dado
        Integer id = pacienteDesdeDb.getId();
        //cuando
        Paciente pacienteRecuperado = pacienteService.buscarPorId(id).get();
        // entonces
        assertEquals(id, pacienteRecuperado.getId());
    }

    @Test
    @DisplayName("Listar todos los pacientes")
    void caso3(){
        //Dado
        List<Paciente> pacientes;
        // cuando
        pacientes = pacienteService.buscarTodos();
        // entonces
        assertFalse(pacientes.isEmpty());
    }

}