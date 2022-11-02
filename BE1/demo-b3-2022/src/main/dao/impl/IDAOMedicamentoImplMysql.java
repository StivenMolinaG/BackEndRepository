package main.dao.impl;

import main.dao.IDaoMedicamento;
import main.model.Medicamento;

import java.sql.SQLException;

public class IDAOMedicamentoImplMysql implements IDaoMedicamento {

    private final static String DB_JDBC_DRIVER = "org.mysql.Driver";
    private final static String DB_URL = "jdbc:h2:~/h2-database-farmacia";
    private final static String DB_USER ="root";
    private final static String DB_PASSWORD = "";

    @Override
    public Medicamento guardar(Medicamento medicamento) throws SQLException {



        return null;
    }
}
