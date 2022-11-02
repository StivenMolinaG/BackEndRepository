package main.dao.impl;

import main.dao.IDaoMedicamento;
import main.model.Medicamento;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class IDaoMedicamentoImpl implements IDaoMedicamento {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/h2-database-farmacia";
    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "myPassword";

    private final static String CREATE_TABLE_FARMACIA = "CREATE TABLE IF NOT EXISTS medicamentos (id int primary key, nombre varchar(255), laboratorio varchar(255), cantidad int, precio double)";

    private final static String SQL_INSERT = "INSERT INTO medicamentos(id, nombre, laboratorio, cantidad, precio) VALUES (?, ?, ?, ?, ?)";
    @Override
    public Medicamento guardar(Medicamento medicamento) throws SQLException {

        Connection connection = null;
        Statement statementCreate = null;
        DriverManager driverManager = null;

        try {
            Class.forName(DB_JDBC_DRIVER).getDeclaredConstructor().newInstance();
            connection = driverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            statementCreate = connection.createStatement();
            statementCreate.execute(CREATE_TABLE_FARMACIA);

            PreparedStatement preparedStatementInsert = connection.prepareStatement(SQL_INSERT);
            preparedStatementInsert.setInt(1,1);
            preparedStatementInsert.setString(2,medicamento.getNombre());
            preparedStatementInsert.setString(3,medicamento.getLaboratorio());
            preparedStatementInsert.setInt(4,medicamento.getCantidad());
            preparedStatementInsert.setDouble(5,medicamento.getPrecio());

            preparedStatementInsert.execute();

        }catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e){
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return null;
    }
}
