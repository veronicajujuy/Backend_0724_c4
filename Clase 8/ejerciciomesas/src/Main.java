import org.apache.log4j.Logger;

import java.sql.*;

public class Main {
    public static Logger LOGGER = Logger.getLogger(Main.class);
    public static String SQL_CREATE = "DROP TABLE IF EXISTS FIGURAS; " +
            "CREATE TABLE FIGURAS (ID INT AUTO_INCREMENT PRIMARY KEY," +
            "TIPO_FIGURA VARCHAR(50) NOT NULL, COLOR VARCHAR(50) NOT NULL)";
    public static String SQL_INSERT = "INSERT INTO FIGURAS VALUES (DEFAULT, 'CIRCULO','ROJO')," +
            "(DEFAULT, 'CIRCULO','VERDE'),(DEFAULT, 'CUADRADO','ROJO'),(DEFAULT, 'CUADRADO','CYAN')," +
            "(DEFAULT, 'CUADRADO','NEGRO')";
    public static String SQL_SELECT = "SELECT * FROM FIGURAS WHERE COLOR = 'ROJO'";

    public static void main(String[] args) {
        Connection connection = null;
        try{
            connection = getConnection();
            //CREAR LA TABLA
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE);
            // insertar valores
            statement.execute(SQL_INSERT);
            // mostrar figuras rojas
            ResultSet resultSet = statement.executeQuery(SQL_SELECT);
            while (resultSet.next()){
                LOGGER.info("figura: "+resultSet.getInt(1)+" - "+resultSet.getString(2)+
                        " - "+resultSet.getString(3));
            }

        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:./clase8_2","sa","sa");
    }
}
