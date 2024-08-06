package service;

import dao.IDao;
import model.Medicamento;

import java.util.List;

public class MedicamentoService {
    private IDao<Medicamento> medicamentoIDao;

    public MedicamentoService(IDao<Medicamento> medicamentoIDao) {
        this.medicamentoIDao = medicamentoIDao;
    }

    public Medicamento guardarMedicamento(Medicamento medicamento){
        return medicamentoIDao.guardar(medicamento);
    }
    public Medicamento buscarPorNombre(String nombre){
        return medicamentoIDao.buscarPorNombre(nombre);
    }

    public List<Medicamento> buscarTodos(){
        return medicamentoIDao.buscarTodos();
    }

}
