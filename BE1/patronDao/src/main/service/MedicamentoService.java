package main.service;

import main.dao.IDaoMedicamento;
import main.dao.impl.IDaoMedicamentoImpl;
import main.model.Medicamento;

import java.sql.SQLException;

public class MedicamentoService {
    private IDaoMedicamento medicamentoDao;

    public MedicamentoService(){
        this.medicamentoDao = new IDaoMedicamentoImpl();
    }

    public Medicamento guardar(Medicamento medicamento) throws SQLException {
        return medicamentoDao.guardar(medicamento);
    }
}
