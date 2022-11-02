package main.dao;

import main.model.Medicamento;

import java.sql.SQLException;

public interface IDaoMedicamento {

    Medicamento guardar(Medicamento medicamento) throws SQLException;

}
