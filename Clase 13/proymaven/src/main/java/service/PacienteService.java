package service;

import dao.IDao;
import model.Paciente;

import java.util.List;

public class PacienteService {
    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente guardarPaciente(Paciente paciente){
        return pacienteIDao.guardar(paciente);
    }

    public Paciente buscarPorId(Integer id){
        return pacienteIDao.buscarPorId(id);
    }
    public List<Paciente> buscarTodos(){
        return pacienteIDao.listaTodos();
    }
}
