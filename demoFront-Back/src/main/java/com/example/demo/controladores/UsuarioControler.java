package com.example.demo.controladores;

import com.example.demo.Entity.Socio;
import com.example.demo.Entity.Usuario;
import com.example.demo.Services.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioControler {
    @Autowired
    public UsuarioServicio usuarioServicio;

    @GetMapping("/")
    public List<Usuario> getAll() {

        return usuarioServicio.getUsuario();
    }
    @GetMapping("/{idUsuario}")
    public Optional<Usuario> getByid(@PathVariable("idUsuario") long idUsuario) {

        return usuarioServicio.getUsuario(idUsuario);    }

    @PostMapping
    public void saveUpdate(@RequestBody Usuario usuario) {

        usuarioServicio.saveOrUpdate(usuario);
    }
}
