import main.model.Medicamento;
import main.service.MedicamentoService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        MedicamentoService service = new MedicamentoService();
        Medicamento medicamento1 = new Medicamento("analgesico","Pfizer",30,3.000);

        service.guardar(medicamento1);
    }
}