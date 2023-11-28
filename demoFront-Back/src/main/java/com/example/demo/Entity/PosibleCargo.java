package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Table(name="posiblescargos")
public class PosibleCargo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idPosibleCargo;

    @Column(name="nombre_posible_cargo")
    private String nombre_posible_cargo;

    public Long getIdPosibleCargo() {
        return idPosibleCargo;
    }

    public void setIdPosibleCargo(Long idPosibleCargo) {
        this.idPosibleCargo = idPosibleCargo;
    }

    public String getNombre_posible_cargo() {
        return nombre_posible_cargo;
    }

    public void setNombre_posible_cargo(String nombre_posible_cargo) {
        this.nombre_posible_cargo = nombre_posible_cargo;
    }
}