package com.digitalhouse;

import com.digitalhouse.entity.Cuenta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS CUENTA; CREATE TABLE CUENTA "
            + "("
            + " ID INT PRIMARY KEY,"
            + " NOMBRE varchar(100) NOT NULL, "
            + " NRO_CUENTA NUMERIC(10, 2) NOT NULL,"
            + " SALDO INT NOT NULL"
            + " )";
    private static final String SQL_INSERT =  "INSERT INTO CUENTA (ID, NOMBRE, NRO_CUENTA, SALDO) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE =  "UPDATE CUENTA SET SALDO=? WHERE ID=?";

    public static void main(String[] args) throws Exception {
        Cuenta cuenta = new Cuenta(1237890, "Sueldo", 10);
        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);


            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            psInsert.setInt(1, 1);
            psInsert.setString(2, cuenta.getNombre());
            psInsert.setInt(3, cuenta.getNroCuenta());
            psInsert.setDouble(4, cuenta.getSaldo());

            psInsert.execute();

            /*
             * Pueden probar y jugar comentando los setAutoCommit y el commit
             * (que trabajan en conjunto con el rollback) para ver cómo se realiza o no la transacción
             */

            connection.setAutoCommit(false);

            PreparedStatement psUpdate2 = connection.prepareStatement(SQL_UPDATE);
            psUpdate2.setDouble(1, cuenta.getSaldo() + 10);
            psUpdate2.setInt(2, 1);
            psUpdate2.execute();

            //int b = 4 / 0;

            connection.commit();
            connection.setAutoCommit(true);

            System.out.println("PRIMER CONEXION");
            String select = "SELECT * FROM CUENTA";
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(select);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " - " + rs.getString(2) + " - "
                        + rs.getInt(3) + " - " + rs.getString(4));
            }

        } catch (Exception e) {
            //assert connection != null;
            e.printStackTrace();
            connection.rollback();

        } finally {
            connection.close();
        }

        System.out.println("");
        System.out.println("SEGUNDA CONEXION");
        Connection connection2 = getConnection();
        String sql = "SELECT * FROM CUENTA";
        Statement sqlSmt = connection2.createStatement();
        ResultSet rs = sqlSmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " - " + rs.getString(2) + " - "
                    + rs.getInt(3) + " - " + rs.getString(4));
        }

    }

    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").getDeclaredConstructor().newInstance();
        return DriverManager.getConnection("jdbc:h2:~/db-cuentas", "user", "");

        /*DriverManager driverManager = null;
        Connection conn = null;

        try{
            Class.forName("org.h2.Driver").getDeclaredConstructor().newInstance();
            conn = driverManager.getConnection("jdbc:h2:~/db-cuentas", "root", "");
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        return conn;*/
    }
}
