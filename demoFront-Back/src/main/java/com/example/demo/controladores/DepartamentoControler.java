package com.example.demo.controladores;


import com.example.demo.Entity.Departamento;
import com.example.demo.Entity.Usuario;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Services.DepartamentoServicio;
import com.example.demo.Services.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/departamentos")
public class DepartamentoControler {
    @Autowired
    private DepartamentoServicio departamentoServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/lista")
    public List<Departamento> getAll() {

        return departamentoServicio.getDepartamento();
    }

    @GetMapping("/{idDepartamento}")
    public Optional<Departamento> getByid(@PathVariable("idDepartamento") Long idDepartamento) {
        return departamentoServicio.getDepartamento(idDepartamento);
    }

    @PostMapping
    public void saveUpdate(@RequestBody Departamento departamento) {

        departamentoServicio.saveOrUpdate(departamento);
    }

    @DeleteMapping("/delete/{idDepartamento}")
    public void deleteById(@PathVariable Long idDepartamento) {
        departamentoServicio.delete(idDepartamento)
        ;
    }
    @Transactional
    @PutMapping("/act/{idDepartamento}")
    public ResponseEntity<Departamento> updateDepartamento(@PathVariable long idDepartamento, @RequestBody Departamento departamentoDetalles) {
        Departamento updateDepartamento = departamentoServicio.findById(idDepartamento).orElseThrow(() -> new ResourceNotFoundException("No existe Departamento con id: " + idDepartamento));
        updateDepartamento.setJerarquia(departamentoDetalles.getJerarquia());
        updateDepartamento.setnombre_departamento(departamentoDetalles.getnombre_departamento());
        departamentoServicio.saveOrUpdate(updateDepartamento);
        return ResponseEntity.ok(updateDepartamento);   }

    @Transactional
    @PostMapping("/{idDepartamento}/usuarios")
    public void asignarUsuario(@PathVariable("idDepartamento") Long idDepartamento, @RequestBody long idUsuario) {
        Departamento departamento = departamentoServicio.getDepartamento(idDepartamento).get();
        Usuario usuario = usuarioServicio.getUsuario(idUsuario).get();
        departamento.getUsuarios().add(usuario);
    }
}
