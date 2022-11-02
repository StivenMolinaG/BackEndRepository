package service;

import daos.IDao;
import entidades.Odontologo;

public class OdontologoService {
    private IDao<Odontologo> odontologoDao;

    public void setOdontologoDao(IDao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public Odontologo crear(Odontologo odontologo){
        return this.odontologoDao.crear(odontologo);
    }
}
