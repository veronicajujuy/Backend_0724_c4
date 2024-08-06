package test;

import dao.impl.DaoH2;
import model.Medicamento;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.MedicamentoService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MedicamentoServiceTest {
    private static final Logger logger = Logger.getLogger(MedicamentoServiceTest.class);
    private static MedicamentoService medicamentoService = new MedicamentoService(new DaoH2());

    @BeforeAll
    static void crearTabla(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection =  DriverManager.getConnection("jdbc:h2:./medicamentos;INIT=RUNSCRIPT FROM 'create.sql'","sa","sa");
        }catch (Exception e){
            logger.error(e.getMessage());
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    @Test
    @DisplayName("Testear que se agregue un medicamento de manera correcta")
    void caso1(){
        //DADO
        Medicamento medicamento = new Medicamento("LORATADINA", "BAGO",12,360);
        //CUANDO
        Medicamento medicamentoDesdeBD = medicamentoService.guardarMedicamento(medicamento);
        // entonces
        assertNotNull(medicamentoDesdeBD);
    }

    @Test
    @DisplayName("Testear que se busque un medicamento correctamente")
    void caso2(){
        //DADO
        String nombre = "ACTRON";
        //CUANDO
        Medicamento medicamentoDesdeBD = medicamentoService.buscarPorNombre(nombre.toUpperCase());
        // entonces
        assertEquals(nombre, medicamentoDesdeBD.getNombre());
    }

    @Test
    @DisplayName("Testear que se listen todos los medicamentos")
    void caso3(){
        //DADO
        List<Medicamento> medicamentos;
        //CUANDO
        medicamentos = medicamentoService.buscarTodos();
        // entonces
        assertNotNull(medicamentos);
    }


}