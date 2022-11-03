package daos;

import db.H2DB;
import entity.Odontologo;
import entity.Paciente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PacienteDaoH2 implements IDao<Paciente>{
    private final Connection conn = H2DB.getConecction();

    @Override
    public Paciente crear(Paciente paciente) {
        PreparedStatement preparedStatement;
        try{
            conn.setAutoCommit(false);
            preparedStatement = conn.prepareStatement("INSERT INTO paciente (nombre, apellido, domicilio, DNI, fechaAlta) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1,paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(3, paciente.getDomicilio());
            preparedStatement.setString(4, paciente.getDNI());
            preparedStatement.setDate(5, paciente.getFechaAlta());

            preparedStatement.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
        return paciente;
    }

    @Override
    public Paciente buscar(int id) {
        return null;
    }

    @Override
    public List<Paciente> buscarTodos() {
        return null;
    }

    @Override
    public boolean actualizar(Paciente paciente) {
        return false;
    }

    @Override
    public boolean borrar(int id) {
        return false;
    }
}
