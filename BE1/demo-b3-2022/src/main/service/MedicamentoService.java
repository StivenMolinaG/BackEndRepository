package main.service;

import main.dao.IDaoMedicamento;
import main.dao.impl.IDaoMedicamentoImplH2;
import main.model.Medicamento;

import java.sql.SQLException;

public class MedicamentoService {

    private IDaoMedicamento medicamentoDao;

    public MedicamentoService() {
        this.medicamentoDao = new IDaoMedicamentoImplH2();
    }

    public Medicamento guardar(Medicamento medicamento) throws SQLException {
        return medicamentoDao.guardar(medicamento);
    }
}
