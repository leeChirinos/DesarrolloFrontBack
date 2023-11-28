package com.example.demo.Services;

import com.example.demo.Entity.Departamento;
import com.example.demo.Entity.Socio;
import com.example.demo.Repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class DepartamentoServicio  {

    @Autowired
    DepartamentoRepository departamentoRepository;

    public List<Departamento> getDepartamento() {

        return departamentoRepository.findAll();
    }
    public Optional<Departamento> getDepartamento(Long idDepartamento) {
        return departamentoRepository.findById(idDepartamento);
    }
    public void saveOrUpdate(Departamento departamento) {

        departamentoRepository.save(departamento);
    }

    public void delete(Long idDepartamento) {
        departamentoRepository.deleteById(idDepartamento);
    }

    public Optional<Departamento> findById(long idDepartamento) {
        return departamentoRepository.findById(idDepartamento);
    }
}
