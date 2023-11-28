package com.example.demo.Repository;

import com.example.demo.Entity.Departamento;
import com.example.demo.Entity.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    List<Departamento> findByJerarquia(String jerarquia);

}
