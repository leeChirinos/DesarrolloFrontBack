package com.example.demo.controladores;

import com.example.demo.Entity.Domicilio;
import com.example.demo.Entity.Socio;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Services.DomicilioServicio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/domicilios")
public class DomicilioControler {
    @Autowired
    public DomicilioServicio domicilioServicio;

    @GetMapping("/")
    public List<Domicilio> getAll() {

        return domicilioServicio.getDomicilio();
    }
    @GetMapping("/idDomicilio")
    public Optional<Domicilio> getByid(@PathVariable("idDomicilio") Long idDomicilio) {

        return domicilioServicio.getDomicilio(idDomicilio);
    }

    @PostMapping
    public void saveUpdate(@RequestBody Domicilio domicilio) {

        domicilioServicio.saveOrUpdate(domicilio);
    }
    @Transactional
    @PutMapping("/actualizar/{idDomicilio}")
    public ResponseEntity<Domicilio> updateDomicilio(@PathVariable long idDomicilio, @RequestBody Domicilio domicilioDetalles) {
        Domicilio updateDomicilio = domicilioServicio.findById(idDomicilio).
                orElseThrow(() -> new ResourceNotFoundException("No existe Socio con id: " + idDomicilio));
        updateDomicilio.setCalle(domicilioDetalles.getCalle());
        updateDomicilio.setAltura(domicilioDetalles.getAltura());
        updateDomicilio.setPiso(updateDomicilio.getPiso());
        domicilioServicio.saveOrUpdate(updateDomicilio);
        return ResponseEntity.ok(updateDomicilio);
    }
    @DeleteMapping("/del/{idDomicilio}")
    public void deleteById(@PathVariable Long idDomicilio) {
        domicilioServicio.delete(idDomicilio)
        ;
    }

}
