package dh.backend.clinica.service;

import dh.backend.clinica.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {
    Paciente guardarPaciente(Paciente paciente);

    Optional<Paciente> buscarPorId(Integer id);
    List<Paciente> buscarTodos();

    void modificarPaciente(Paciente paciente);

    void eliminarPaciente(Integer id);
}
