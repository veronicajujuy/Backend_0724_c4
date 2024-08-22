package dh.backend.clinica.dao.impl;

import dh.backend.clinica.dao.IDao;
import dh.backend.clinica.db.H2Connection;
import dh.backend.clinica.model.Odontologo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class DaoH2Odontolog implements IDao<Odontologo> {

    public static final Logger LOGGER = LoggerFactory.getLogger(DaoH2Odontolog.class);
    public static final String BUSCAR_ID = "SELECT * FROM ODONTOLOGOS WHERE ID = ?";
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        return null;
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        Connection connection = null;
        Odontologo odontologoEncontrado = null;
        try{
            connection = H2Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(BUSCAR_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Integer iddb = resultSet.getInt(1);
                String nro_matricula = resultSet.getString(2);
                String nombre = resultSet.getString(3);
                String apellido = resultSet.getString(4);
                odontologoEncontrado = new Odontologo(id, nro_matricula,nombre,apellido);
            }
            LOGGER.info("Odontologo encontrado: "+odontologoEncontrado);

        } catch (ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return odontologoEncontrado;
    }

    @Override
    public List<Odontologo> listaTodos() {
        return null;
    }

    @Override
    public void modificar(Odontologo odontologo) {

    }

    @Override
    public void eliminar(Integer id) {

    }
}
