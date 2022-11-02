import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) {
        Connection connection = null;
        DriverManager driverManager = null;

        try {
            Class.forName("org.h2.Driver").getDeclaredConstructor().newInstance();
            connection = driverManager.getConnection("jdbc:h2:./odontologia", "sa", "myPassword");
        }catch (Exception e){
            LOGGER.error("ERROOOOOOR");
        }
    }
}