package dh.backend.clinica.service.impl;

import dh.backend.clinica.dao.IDao;
import dh.backend.clinica.entity.Odontologo;
import dh.backend.clinica.repository.IOdontologoRepository;
import dh.backend.clinica.service.IOdontologoService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService {
    private IOdontologoRepository odontologoRepository;

    public OdontologoService(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Optional<Odontologo> buscarPorId(Integer id) {
        return odontologoRepository.findById(id);
    }
}
