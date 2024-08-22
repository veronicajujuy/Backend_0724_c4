package dh.backend.clinica.service;

import dh.backend.clinica.dao.IDao;
import dh.backend.clinica.model.Odontologo;
import org.springframework.stereotype.Service;

@Service
public class OdontologoService {
    public IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo buscarPorId(Integer id){
        return odontologoIDao.buscarPorId(id);
    }
}
