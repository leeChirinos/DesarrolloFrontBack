package com.example.demo.controladores;

import com.example.demo.Entity.PosibleCargo;
import com.example.demo.Entity.Usuario;
import com.example.demo.Services.PosibleCargoServicio;
import com.example.demo.Services.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/posiblescargos")
public class PosibleCargoControler {
    @Autowired
    public PosibleCargoServicio posibleCargoServicio;

    @GetMapping("/")
    public List<PosibleCargo> getAll() {

        return posibleCargoServicio.getPosibleCargo();
    }
    @GetMapping("/{idPosibleCargo}")
    public Optional<PosibleCargo> getByid(@PathVariable("idPosibleCargo") Long idPosibleCargo) {

        return posibleCargoServicio.getPosibleCargo(idPosibleCargo);
    }

    @PostMapping
    public void saveUpdate(@RequestBody PosibleCargo posibleCargo) {

        posibleCargoServicio.saveOrUpdate(posibleCargo);
    }

}
