package com.example.demo.Repository;

import com.example.demo.Entity.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SocioRepository extends JpaRepository<Socio,Long> {

    List<Socio> findBynombreSocioContaining(String nombreSocio);

    List<Socio> findByfechaAltaBetween(Date fechaAlta, Date fechaActual);

    List<Socio> findBytipoSocioContaining(String tipoSocio);

}