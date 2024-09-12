package dh.backend.clinica.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dh.backend.clinica.entity.Domicilio;
import dh.backend.clinica.entity.Paciente;
import dh.backend.clinica.service.impl.PacienteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@Transactional
class PacienteControllerTest {
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private Paciente paciente;

    void crearPaciente(){
        Domicilio domicilio = new Domicilio(null,"Falsa",145,"CABA","Buenos Aires");
        paciente = new Paciente();
        paciente.setApellido("Castro");
        paciente.setNombre("Maria");
        paciente.setDni("48974646");
        paciente.setFechaIngreso(LocalDate.of(2024,7,15));
        paciente.setDomicilio(domicilio);
    }

    @Test
    @DisplayName("Testear el guardado de un paciente")
    void guardarPaciente() throws Exception {
        crearPaciente();
        //convertir el paciente a un objeto JSON
        String pacienteJSON = objectMapper.writeValueAsString(paciente);

        //http://localhost:8080/paciente/guardar
        mockMvc.perform(post("/paciente/guardar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(pacienteJSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.apellido").value("Castro"))
                .andExpect(jsonPath("$.nombre").value("Maria"))
                .andExpect(jsonPath("$.domicilio.calle").value("Falsa"))
                .andExpect(jsonPath("$.domicilio.localidad").value("CABA"));
    }

    @Test
    @DisplayName("Buscar por Id")
    void buscarPorId() throws Exception {
        crearPaciente();
        Paciente pacienteDesdeDB = pacienteService.guardarPaciente(paciente);

        mockMvc.perform(get("/paciente/buscar/{id}", pacienteDesdeDB.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.apellido").value("Castro"))
                .andExpect(jsonPath("$.nombre").value("Maria"))
                .andExpect(jsonPath("$.domicilio.calle").value("Falsa"))
                .andExpect(jsonPath("$.domicilio.localidad").value("CABA"));

    }

    @Test
    @DisplayName("Buscar por Id un paciente que no existe")
    void buscarPorId_pacienteNoexistente() throws Exception {

        mockMvc.perform(get("/paciente/buscar/{id}", 10)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}