package com.example.demo.Services;
import com.example.demo.Entity.Socio;
import com.example.demo.Repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SocioServicio {
    @Autowired
    SocioRepository socioReposity;
    //RF2
    public List<Socio> getSocio() {

        return socioReposity.findAll();
    }

    public Optional<Socio> getSocio(long idSocio) {

        return socioReposity.findById(idSocio);
    }
    public Socio saveOrUpdate(Socio socio) {

        socioReposity.save(socio);
        return socio;
    }
      public List<Socio> getnombreSocio(String nombreSocio) {

        return socioReposity.findBynombreSocioContaining(nombreSocio);
    }

    public List<Socio> getfechaAlta(Date fechaMinima) {

        return socioReposity.findByfechaAltaBetween(fechaMinima, new Date());
    }

    public List<Socio> gettipoSocio(String tipoSocio) {

        return socioReposity.findBytipoSocioContaining(tipoSocio);
}

    public Optional<Socio> findById(long idSocio) {
        return socioReposity.findById(idSocio);
    }

    public void delete(Long idSocio){
        socioReposity.deleteById(idSocio);
    }

}
