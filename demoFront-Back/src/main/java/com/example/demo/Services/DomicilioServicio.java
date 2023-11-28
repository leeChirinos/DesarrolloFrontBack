package com.example.demo.Services;


import com.example.demo.Entity.Domicilio;
import com.example.demo.Entity.Socio;
import com.example.demo.Repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioServicio {
    @Autowired
    DomicilioRepository domicilioRepository;
    public List<Domicilio> getDomicilio() {

        return domicilioRepository.findAll();
    }

    public Optional<Domicilio> getDomicilio(Long idDomicilio) {

        return domicilioRepository.findById(idDomicilio);
    }

    public void saveOrUpdate(Domicilio domicilio) {

        domicilioRepository.save(domicilio);
    }
    public Optional<Domicilio> findById(long idDomicilio) {
        return domicilioRepository.findById(idDomicilio);
    }

    public void delete(Long idDomicilio) {
        domicilioRepository.deleteById(idDomicilio);
    }
}
