package com.example.demo.Services;

import com.example.demo.Entity.PosibleCargo;
import com.example.demo.Entity.Usuario;
import com.example.demo.Repository.PosibleCargoRepository;
import com.example.demo.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosibleCargoServicio {
    @Autowired
    PosibleCargoRepository posibleCargoRepository;
    public List<PosibleCargo> getPosibleCargo() {

        return posibleCargoRepository.findAll();
    }

    public void saveOrUpdate(PosibleCargo posibleCargo) {

       posibleCargoRepository.save(posibleCargo);
    }

    public Optional<PosibleCargo> getPosibleCargo(long idPosibleCargo) {

        return posibleCargoRepository.findById(idPosibleCargo);
    }
}
