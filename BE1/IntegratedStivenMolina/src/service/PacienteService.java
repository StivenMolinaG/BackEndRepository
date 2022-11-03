package service;

import daos.IDao;
import entity.Odontologo;
import entity.Paciente;

public class PacienteService {

    private IDao<Paciente> pacienteDao;

    public void setPacienteDao(IDao<Paciente> pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    public Paciente crear(Paciente paciente){
        return this.pacienteDao.crear(paciente);
    }
}
