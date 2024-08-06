import db.H2Connection;
import model.Cuenta;
import org.apache.log4j.Logger;

import java.sql.*;

public class Main {
    public static final Logger logger = Logger.getLogger(Main.class);
    public static final String CREATE = "DROP TABLE CUENTAS IF EXISTS;" +
            "CREATE TABLE CUENTAS( ID INT AUTO_INCREMENT PRIMARY KEY," +
            "NROCUENTA VARCHAR(15) NOT NULL, NOMBRE VARCHAR(25), SALDO DECIMAL(7,2) NOT NULL) ";

    public static final String SELECT_ALL = "SELECT * FROM CUENTAS";

    public static final String INSERT = "INSERT INTO CUENTAS VALUES (DEFAULT,?,?,?)";
    public static final String UPDATE = "UPDATE CUENTAS SET SALDO=? WHERE ID=?";

    public static void main(String[] args) {
        Connection connection = null;
        Cuenta cuenta = new Cuenta("145687","pepito.mp", 150);
        Cuenta cuentaDesdeDb = null;
        try{
            connection = H2Connection.getConnection();
            Statement statement = connection.createStatement();
            //Crear base de datos
            statement.execute(CREATE);
            //Insertar datos
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, cuenta.getNroCuenta());
            preparedStatement.setString(2, cuenta.getNombre());
            preparedStatement.setDouble(3, cuenta.getSaldo());
            preparedStatement.executeUpdate();

            // Recuperar valores de la base de datos
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()){
                Integer id = resultSet.getInt(1);
                String nroCuenta = resultSet.getString(2);
                String nombre = resultSet.getString(3);
                double saldo = resultSet.getDouble(4);
                cuentaDesdeDb = new Cuenta(id, nroCuenta, nombre, saldo);
            }
            logger.info("cuenta"+ cuentaDesdeDb);
            // update
            // esto lo vamos a tratar como una transaccion
            connection.setAutoCommit(false);
            try {
                preparedStatement = connection.prepareStatement(UPDATE);
                preparedStatement.setDouble(1,cuentaDesdeDb.getSaldo()+15);
                preparedStatement.setInt(2, cuentaDesdeDb.getId());
                preparedStatement.executeUpdate();
                //Integer division = 10/0;
                connection.commit();
                cuentaDesdeDb.setSaldo(cuentaDesdeDb.getSaldo()+15);
            }catch (Exception e){
                connection.rollback();
                logger.error(e.getMessage());
            }finally {
                connection.setAutoCommit(true);
            }
            logger.info("cuenta"+ cuentaDesdeDb);

        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }

    }
}
