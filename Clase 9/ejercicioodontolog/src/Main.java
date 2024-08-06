import db.H2Connection;
import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;

public class Main {
    public static final Logger logger = Logger.getLogger(Main.class);
    public static final String CREATE = "DROP TABLE IF EXISTS ODONTOLOGOS;" +
            "CREATE TABLE ODONTOLOGOS(ID INT AUTO_INCREMENT PRIMARY KEY," +
            "APELLIDO VARCHAR(50) NOT NULL, NOMBRE VARCHAR(50) NOT NULL," +
            "MATRICULA VARCHAR(25) NOT NULL )";

    public static final String INSERT = "INSERT INTO ODONTOLOGOS VALUES(DEFAULT,?,?,?)";
    public static final String SELECT_ALL ="SELECT * FROM ODONTOLOGOS";
    public static final String UPDATE = "UPDATE ODONTOLOGOS SET MATRICULA = ? WHERE ID =?";
    public static void main(String[] args) {
        Connection connection = null;
        Odontologo odontologo = new Odontologo("PANICO","CARLOS","123");
        Odontologo odontologoDB = null;
        try{
            connection = H2Connection.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(CREATE);

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, odontologo.getApellido());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getMatricula());
            preparedStatement.execute();

            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String apellido = resultSet.getString(2);
                String nombre = resultSet.getString(3);
                String matricula = resultSet.getString(4);
                odontologoDB = new Odontologo(id, apellido, nombre, matricula);
                logger.info(odontologoDB);
            }

            // transaccion
            connection.setAutoCommit(false);
            try{
                preparedStatement = connection.prepareStatement(UPDATE);
                preparedStatement.setString(1,"456");
                preparedStatement.setInt(2, odontologoDB.getId());
                preparedStatement.execute();
                connection.commit();

            }catch (Exception e){
                connection.rollback();
                logger.error(e.getMessage());
            }finally {
                connection.setAutoCommit(true);
            }

            resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String apellido = resultSet.getString(2);
                String nombre = resultSet.getString(3);
                String matricula = resultSet.getString(4);
                odontologoDB = new Odontologo(id, apellido, nombre, matricula);
                logger.info(odontologoDB);
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
    }
}
