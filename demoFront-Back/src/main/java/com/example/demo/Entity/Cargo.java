package com.example.demo.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table(name="cargos")
public class Cargo{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idCargo;

    @ManyToOne(fetch =FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

    @ManyToOne(fetch =FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch =FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_posiblecargo")
    private PosibleCargo posiblecargo;


    }





