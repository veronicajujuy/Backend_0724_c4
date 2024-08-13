package dao.impl;

import dao.IDao;
import db.H2Connection;
import model.Domicilio;
import model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DaoH2Paciente implements IDao<Paciente> {
    public static final Logger logger = Logger.getLogger(DaoH2Domicilio.class);
    public static final String INSERT = "INSERT INTO PACIENTES VALUES(DEFAULT,?,?,?,?,? )";
    public static final String SELECT_ID = "SELECT * FROM PACIENTES WHERE ID = ?";
    public static final String SELECT_ALL = "SELECT * FROM PACIENTES";

    // esta instanciacion de la clase daoH2Domicilio me va a permitir acceder a los metodos de domicilio
    private DaoH2Domicilio daoH2Domicilio = new DaoH2Domicilio();
    @Override
    public Paciente guardar(Paciente paciente) {
        Connection connection = null;
        Paciente pacienteARetornar = null;
        Domicilio domicilioAuxiliar = daoH2Domicilio.guardar(paciente.getDomicilio());
        try{
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, paciente.getApellido());
            preparedStatement.setString(2, paciente.getNombre());
            preparedStatement.setString(3, paciente.getDni());
            preparedStatement.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
            preparedStatement.setInt(5, domicilioAuxiliar.getId());
            preparedStatement.executeUpdate();
            connection.commit();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                Integer id = resultSet.getInt(1);
                pacienteARetornar = new Paciente(id, paciente.getApellido(), paciente.getNombre(),
                        paciente.getDni(), paciente.getFechaIngreso(), domicilioAuxiliar);
            }
            logger.info("paciente "+ pacienteARetornar);

        }catch (Exception e){
            if(connection != null){
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    logger.error(e.getMessage());
                } finally {
                    try {
                        connection.setAutoCommit(true);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return pacienteARetornar;
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        Connection connection = null;
        Paciente pacienteEncontrado = null;
        try{
            connection = H2Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer idDB = resultSet.getInt(1);
                String apellido = resultSet.getString(2);
                String nombre = resultSet.getString(3);
                String dni = resultSet.getString(4);
                LocalDate fechaIngreso = resultSet.getDate(5).toLocalDate();
                Integer id_domicilio = resultSet.getInt(6);
                Domicilio domicilio = daoH2Domicilio.buscarPorId(id_domicilio);
                pacienteEncontrado = new Paciente(idDB, apellido, nombre, dni, fechaIngreso, domicilio);
            }
            if(pacienteEncontrado!= null){
                logger.info("paciente encontrado "+ pacienteEncontrado);
            } else {
                logger.info("paciente no encontrado");
            }

        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return pacienteEncontrado;
    }

    @Override
    public List<Paciente> listaTodos() {
        Connection connection = null;
        List<Paciente> pacientes = new ArrayList<>();
        Paciente pacienteDesdeDB = null;
        try{
            connection = H2Connection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()){
                Integer idDB = resultSet.getInt(1);
                String apellido = resultSet.getString(2);
                String nombre = resultSet.getString(3);
                String dni = resultSet.getString(4);
                LocalDate fechaIngreso = resultSet.getDate(5).toLocalDate();
                Integer id_domicilio = resultSet.getInt(6);
                Domicilio domicilio = daoH2Domicilio.buscarPorId(id_domicilio);
                pacienteDesdeDB = new Paciente(idDB, apellido, nombre, dni, fechaIngreso, domicilio);
                logger.info(pacienteDesdeDB);
                pacientes.add(pacienteDesdeDB);
            }

        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return pacientes;
    }
}
