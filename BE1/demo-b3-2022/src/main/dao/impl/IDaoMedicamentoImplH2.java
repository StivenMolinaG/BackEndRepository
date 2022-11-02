package main.dao.impl;

import main.dao.IDaoMedicamento;
import main.model.Medicamento;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class IDaoMedicamentoImplH2 implements IDaoMedicamento {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/h2-database-farmacia";
    private final static String DB_USER ="root";
    private final static String DB_PASSWORD = "";

    private final static String CREATE_TABLE_FARMACIA = "create table if not exists medicamentos " +
            "(id int auto_increment primary key," +
            "nombre varchar(255)," +
            "laboratorio varchar (255)," +
            "cantidad int," +
            "precio double);";

    @Override
    public Medicamento guardar(Medicamento medicamento) throws SQLException {

        Connection connection = null;

        Statement statementCreate = null;
        Statement statementInsert = null;

        PreparedStatement preparedStatement;


        DriverManager driverManager = null;

        try {
            Class.forName(DB_JDBC_DRIVER).getDeclaredConstructor().newInstance();
            connection = driverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            statementCreate.execute(CREATE_TABLE_FARMACIA);

            statementInsert.execute("INSERT INTO medicamentos(id,nombre,laboratorio,cantidad,precio) " +
                    "VALUES(?, ?, ?, ?, ?)");


        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

        return null;
    }
}
