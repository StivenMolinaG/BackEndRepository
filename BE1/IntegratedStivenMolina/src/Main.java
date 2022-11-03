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
    public static void main(String[] args) throws SQLException {

        H2DB.createTables();
        Odontologo odontologo = new Odontologo(2,"Ana", "Cortes", "54778");
        OdontologoService odontologoService = new OdontologoService();

        odontologoService.setOdontologoDao(new OdontologoDaoH2());
        odontologoService.crear(odontologo);

        Date date = new Date(116,5,5);
        Paciente paciente = new Paciente("Catalina", "Molina", "Carrera 30", "120893", date);
        PacienteService pacienteService = new PacienteService();

        pacienteService.setPacienteDao(new PacienteDaoH2());
        pacienteService.crear(paciente);

        /* Buscando Paciente */
        pacienteService.buscar(1);

        LOGGER.info("Se creo un odontologo y un Paciente con exito");
    }
}