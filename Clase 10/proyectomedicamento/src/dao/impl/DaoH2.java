package dao.impl;

import dao.IDao;
import db.H2Connection;
import model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoH2 implements IDao<Medicamento> {
    public static final Logger logger = Logger.getLogger(DaoH2.class);
    public static final String INSERT = "INSERT INTO MEDICAMENTOS VALUES (DEFAULT, ?,?,?,?)";
    public static final String SELECT_NOMBRE = "SELECT * FROM MEDICAMENTOS WHERE NOMBRE = ?";
    public static final String SELECT_ALL = "SELECT * FROM MEDICAMENTOS";
    @Override
    public Medicamento guardar(Medicamento medicamento) {
        Connection connection = null;
        Medicamento medicamentoARetornar = null;
        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, medicamento.getNombre());
            preparedStatement.setString(2, medicamento.getLaboratorio());
            preparedStatement.setInt(3, medicamento.getCantidad());
            preparedStatement.setDouble(4, medicamento.getPrecio());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                Integer idDesdeDB = resultSet.getInt(1);
                medicamentoARetornar = new Medicamento(idDesdeDB, medicamento.getNombre(), medicamento.getLaboratorio(),
                        medicamento.getCantidad(), medicamento.getPrecio());
            }
            logger.info("medicamento guardado en base de datos"+ medicamentoARetornar );

            connection.commit();

        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }finally {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return medicamentoARetornar;
    }

    @Override
    public Medicamento buscarPorNombre(String nombre) {
        Connection connection = null;
        Medicamento medicamentoEncontrado = null;
        try{
            connection = H2Connection.getConnection();
            // buscar por nombre
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NOMBRE);
            preparedStatement.setString(1, nombre);
            ResultSet resultSet = preparedStatement.executeQuery();
            // iteracion para armar el objeto obtenido desde la bd
            while (resultSet.next()){
                Integer id = resultSet.getInt(1);
                String nombreMed = resultSet.getString(2);
                String laboratorio = resultSet.getString(3);
                int cantidad = resultSet.getInt(4);
                double precio = resultSet.getDouble(5);
                medicamentoEncontrado = new Medicamento(id, nombreMed, laboratorio, cantidad, precio);
            }
            //verificar si se encontro un medicamento o no
            if(medicamentoEncontrado == null){
                logger.info("No se encontro el medicamento");
            } else {
                logger.info("El medicamento encontrado es "+medicamentoEncontrado );
            }

        }catch (Exception e){
            logger.error(e.getMessage());
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
        return medicamentoEncontrado;
    }

    @Override
    public List<Medicamento> buscarTodos() {
        Connection connection = null;
        List<Medicamento> medicamentos = new ArrayList<>();
        Medicamento medicamentoDesdeLaDB = null;
        try{
            connection = H2Connection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()){
                Integer id = resultSet.getInt(1);
                String nombreMed = resultSet.getString(2);
                String laboratorio = resultSet.getString(3);
                int cantidad = resultSet.getInt(4);
                double precio = resultSet.getDouble(5);
                medicamentoDesdeLaDB = new Medicamento(id, nombreMed, laboratorio, cantidad, precio);
                // vamos cargando la lista de medicamentos
                medicamentos.add(medicamentoDesdeLaDB);
                logger.info("medicamento "+ medicamentoDesdeLaDB);
            }

        }catch (Exception e){
            logger.error(e.getMessage());
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
        return medicamentos;
    }
}
