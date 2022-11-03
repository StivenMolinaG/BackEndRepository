import daos.OdontologoDaoH2;
import db.H2DB;
import entity.Odontologo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.OdontologoService;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) {

        H2DB.createTables();
        Odontologo odontologo = new Odontologo(2,"Natalia", "Cortes", "54778");
        OdontologoService odontologoService = new OdontologoService();

        odontologoService.setOdontologoDao(new OdontologoDaoH2());

        LOGGER.info("Se creo un odontologo con exito");
    }
}