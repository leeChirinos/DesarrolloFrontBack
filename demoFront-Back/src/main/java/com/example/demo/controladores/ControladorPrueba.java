package com.example.demo.controladores;

import com.example.demo.Entity.Socio;
import com.example.demo.Services.SocioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/prueba")
public class ControladorPrueba {
    @Autowired
    public SocioServicio socioServicio;
    @GetMapping("/")
    public List<Socio> getAll() {

        return socioServicio.getSocio();
    }

    @GetMapping("/{idSocio}")
    public ModelAndView getByid(@PathVariable("idSocio") String idSocio ){
        Socio socio = socioServicio.getSocio(Long.parseLong(idSocio)).get();
        ModelAndView pepe = new ModelAndView("pepe");
        pepe.addObject("socio" , socio);

        return pepe;

        /*return socioServicio.getSocio(idSocio);*/
    }
}
