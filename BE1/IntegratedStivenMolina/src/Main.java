import daos.OdontologoDaoH2;
import daos.PacienteDaoH2;
import db.H2DB;
import entity.Odontologo;
import entity.Paciente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.OdontologoService;
import service.PacienteService;

import java.sql.*;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) {

        H2DB.createTables();
        Odontologo odontologo = new Odontologo(1,"Natalia", "Cortes", "54778");
        OdontologoService odontologoService = new OdontologoService();

        odontologoService.setOdontologoDao(new OdontologoDaoH2());
        odontologoService.crear(odontologo);

        Date date = new Date(116,5,5);
        Paciente paciente = new Paciente("Stiven", "Molina", "Carrera 30", "120893", date);
        PacienteService pacienteService = new PacienteService();

        pacienteService.setPacienteDao(new PacienteDaoH2());
        pacienteService.crear(paciente);

        LOGGER.info("Se creo un odontologo con exito");
    }
}