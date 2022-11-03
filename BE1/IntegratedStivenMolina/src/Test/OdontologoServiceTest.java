package Test;

import daos.OdontologoDaoH2;
import entidades.Odontologo;
import service.OdontologoService;

import static org.junit.Assert.*;

public class OdontologoServiceTest {

    @org.junit.Test
    public void crear() {
        Odontologo odontologo = new Odontologo(1,"Stiven", "Molina", "1234");
        OdontologoService odontologoService = new OdontologoService();
        odontologoService.setOdontologoDao(new OdontologoDaoH2());
        Odontologo odontologoDB = odontologoService.crear(odontologo);
        assertEquals(odontologo.getId(), odontologoDB.getId());
    }
}