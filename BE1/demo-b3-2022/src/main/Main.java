package main;

import main.model.Medicamento;
import main.service.MedicamentoService;

public class Main {
    public static void main(String[] args) {

        MedicamentoService service = new MedicamentoService();
        Medicamento medicamento1 =
                new Medicamento("Medkit", "Labz", 50, 350.0);

        service.guardar(medicamento1);

    }
}
