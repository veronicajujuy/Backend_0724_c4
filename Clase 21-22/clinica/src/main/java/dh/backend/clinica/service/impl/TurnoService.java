package dh.backend.clinica.service.impl;

import dh.backend.clinica.dao.IDao;
import dh.backend.clinica.entity.Odontologo;
import dh.backend.clinica.entity.Paciente;
import dh.backend.clinica.entity.Turno;
import dh.backend.clinica.repository.ITurnoRepository;
import dh.backend.clinica.service.ITurnoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService implements ITurnoService {
    private ITurnoRepository turnoRepository;
    private PacienteService pacienteService;
    private OdontologoService odontologoService;

    public TurnoService(ITurnoRepository turnoRepository, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoRepository = turnoRepository;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    public Turno guardarTurno(Turno turno){
        Paciente paciente = pacienteService.buscarPorId(turno.getPaciente().getId());
        Odontologo odontologo = odontologoService.buscarPorId(turno.getOdontologo().getId());
        Turno turnoARetornar = null;
        if(paciente!= null && odontologo!= null){
            turno.setPaciente(paciente);
            turno.setOdontologo(odontologo);
            turnoARetornar = turnoIDao.guardar(turno);
        }
        return turnoARetornar;
    }
    public Turno buscarPorId(Integer id){
        return turnoIDao.buscarPorId(id);
    }

    public List<Turno> buscarTodos(){
        return turnoIDao.listaTodos();
    }

    void modificarTurno(Turno turno){
        turnoIDao.modificar(turno);
    }

    void eliminarTurno(Integer id){
        turnoIDao.eliminar(id);
    }


}
