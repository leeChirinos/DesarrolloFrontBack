package com.example.demo.Services;

import com.example.demo.Entity.Socio;
import com.example.demo.Entity.Usuario;
import com.example.demo.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired
    UsuarioRepository usuarioRepository;
    public List<Usuario> getUsuario() {

        return usuarioRepository.findAll();
    }

    public void saveOrUpdate(Usuario usuario) {

        usuarioRepository.save(usuario);
    }

    public Optional<Usuario> getUsuario(long idUsuario) {

        return usuarioRepository.findById(idUsuario);
    }
}
