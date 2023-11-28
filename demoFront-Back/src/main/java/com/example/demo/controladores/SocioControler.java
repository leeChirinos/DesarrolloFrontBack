package com.example.demo.controladores;

import com.example.demo.Entity.Socio;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Services.SocioServicio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/socios")
public class SocioControler {
    @Autowired
    public SocioServicio socioServicio;
    @GetMapping("/")
    public List<Socio> getAll() {

        return socioServicio.getSocio();
    }

    @GetMapping("/{idSocio}")
    public Optional<Socio> getByid(@PathVariable("idSocio") long idSocio) {

        return socioServicio.getSocio(idSocio);
    }

    @PostMapping("/save/{idSocio}")
    public void saveUpdate(@RequestBody Socio socio) {

        socioServicio.saveOrUpdate(socio);
    }
    @Transactional
    @PutMapping("/act/{idSocio}")
     public ResponseEntity<Socio> updateSocio(@PathVariable long idSocio, @RequestBody Socio socioDetalles) {
         Socio updateSocio = socioServicio.findById(idSocio).
                 orElseThrow(() -> new ResourceNotFoundException("No existe Socio con id: " + idSocio));
         updateSocio.setNombreSocio(socioDetalles.getNombreSocio());
         updateSocio.setCuit(socioDetalles.getCuit());
         updateSocio.setTelefono(socioDetalles.getTelefono());
         updateSocio.setEmail(socioDetalles.getEmail());
         updateSocio.setPaginaWeb(socioDetalles.getPaginaWeb());
         updateSocio.setLocalidad(socioDetalles.getLocalidad());
         updateSocio.setFechaAlta(socioDetalles.getFechaAlta());
         updateSocio.setFechaModificacion(socioDetalles.getFechaModificacion());
         updateSocio.setFechaBaja(socioDetalles.getFechaBaja());
         updateSocio.setTipoSocio(socioDetalles.getTipoSocio());
         updateSocio.setActivo(socioDetalles.getActivo());
         updateSocio.setSector(socioDetalles.getSector());
        updateSocio.setDomicilio(socioDetalles.getDomicilio());
         socioServicio.saveOrUpdate(updateSocio);
         return ResponseEntity.ok(updateSocio);
          }
     @GetMapping("/nombreSocio")
    public List<Socio> getByid(@RequestParam String nombreSocio) {

        return socioServicio.getnombreSocio(nombreSocio);
     }

    @GetMapping("/fechaAlta")
    public List<Socio> getByidfechaAlta(@RequestParam String fechaAlta) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date dataFormateada = formato.parse(fechaAlta);
        return socioServicio.getfechaAlta(dataFormateada);
    }

    @GetMapping("/tipoSocio")
    public List<Socio> getByidytipoSocio(@RequestParam String tipoSocio) {

        return socioServicio.gettipoSocio(tipoSocio);
    }


    @DeleteMapping("/delete/{idSocio}")
    public void deleteById(@PathVariable Long idSocio) {
        socioServicio.delete(idSocio);

    }
}