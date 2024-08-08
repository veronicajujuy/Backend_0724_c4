package test;

import dao.impl.DaoH2Paciente;
import model.Domicilio;
import model.Paciente;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.PacienteService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PacienteServiceTest {
    static final Logger logger = Logger.getLogger(PacienteServiceTest.class);
    PacienteService pacienteService = new PacienteService(new DaoH2Paciente());
    @BeforeAll
    static void crearTablas(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:./claserepasoC4;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }
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
        Paciente pacienteDesdeDb = pacienteService.buscarPorId(id);
        // entonces
        assertEquals(id, pacienteDesdeDb.getId());
    }

}