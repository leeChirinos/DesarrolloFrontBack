package com.example.demo.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="departamentos")
public class Departamento {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idDepartamento;

    @Column(name="jerarquia")
    private String jerarquia;
    @Column(name="nombre_departamento")
    private String nombre_departamento;

    @ManyToMany(fetch=FetchType.LAZY,cascade= CascadeType.MERGE)
   @JoinTable(
            name="departamento_usuario", joinColumns = @JoinColumn(name = "id_departamento", referencedColumnName = "idDepartamento"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario",referencedColumnName = "idUsuario"))
    private List<Usuario> usuarios ;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name="departamento_posiblecargo", joinColumns = @JoinColumn(name = "id_departamento", referencedColumnName = "idDepartamento"),
            inverseJoinColumns = @JoinColumn(name = "id_posiblecargo",referencedColumnName = "idPosibleCargo"))
    private List<PosibleCargo> posiblescargos;

    public Departamento() {
    }

    public Departamento(Long idDepartamento,String jerarquia, String nombre_departamento, List<Usuario> usuarios,
                        List<PosibleCargo> posiblescargos) {
        this.idDepartamento = idDepartamento;
        this.jerarquia = jerarquia;
        this.nombre_departamento = nombre_departamento;
        this.usuarios = usuarios;
        this.posiblescargos = posiblescargos;
    }
    public Departamento(String jerarquia, String nombre_departamento) {
        this.nombre_departamento = nombre_departamento;
        this.jerarquia = jerarquia;
    }
    public long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

     public String getJerarquia() {
        return jerarquia;
    }

    public void setJerarquia(String jerarquia) {
        this.jerarquia = jerarquia;
    }

    public String getnombre_departamento() {
        return nombre_departamento;
    }

    public void setnombre_departamento(String nombre_departamento) {
        this.nombre_departamento = nombre_departamento;
    }


    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<PosibleCargo> getPosiblescargos() {
        return posiblescargos;
    }

    public void setPosiblescargos(List<PosibleCargo> posiblescargos) {
        this.posiblescargos = posiblescargos;
    }
}

