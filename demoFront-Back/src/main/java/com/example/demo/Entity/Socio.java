package com.example.demo.Entity;

import com.example.demo.Enum.Activo;
import com.example.demo.Enum.Sector;
import com.example.demo.Enum.TipoSocio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
//RF1
@Data
@Entity
@Table(name="socios")
@AllArgsConstructor
public class Socio implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idSocio;

    @Column(name="nombreSocio")
    private String nombreSocio;

    @Column(name="cuit")
    private String cuit;

    @Column(name="telefono")
    private String telefono;


    @Column(name="email",unique=true)
    private String email;

    @Column(name="paginaWeb")
    private String paginaWeb;

    @Column(name="localidad")
    private String localidad;

    @Column(name="fechaAlta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;

    @Column(name="fechaModificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @Column(name="fechaBaja")
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;

    @Column(name = "tipoSocio", columnDefinition = "enum ('CAMARA', 'EMPRESA')")
    //@Enumerated(value=EnumType.STRING)
    private String tipoSocio;

    @Enumerated(value=EnumType.STRING)
    private Activo activo;

    @Enumerated(value=EnumType.STRING)
    private Sector sector;

    @ManyToOne
    @JoinColumn(name="domicilio")
    Domicilio domicilio;

        /*@OneToMany
        @JoinColumn(name="registrospagos")
        RegistroPago registrospagos;**/

    public Socio () {}

    public Socio(Long idSocio, String nombreSocio, String cuit, String telefono, String email, String paginaWeb,
                 String localidad, Date fechaAlta, Date fechaModificacion, Date fechaBaja, String tipoSocio,
                 Activo activo, Sector sector, Domicilio domicilio) {
        this.idSocio = idSocio;
        this.nombreSocio = nombreSocio;
        this.cuit = cuit;
        this.telefono = telefono;
        this.email = email;
        this.paginaWeb = paginaWeb;
        this.localidad = localidad;
        this.fechaAlta = fechaAlta;
        this.fechaModificacion = fechaModificacion;
        this.fechaBaja = fechaBaja;
        this.tipoSocio = tipoSocio;
        this.activo = activo;
        this.sector = sector;
        this.domicilio = domicilio;
    }

    public Long getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Long idSocio) {
        this.idSocio = idSocio;
    }

    public String getNombreSocio() {
        return nombreSocio;
    }

    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getTipoSocio() { return tipoSocio;
    }

    public void setTipoSocio(String tipoSocio) {
        this.tipoSocio = tipoSocio;
    }

    public Activo getActivo() {
        return activo;
    }

    public void setActivo(Activo activo) {
        this.activo = activo;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "idSocio=" + idSocio +
                ", nombreSocio='" + nombreSocio + '\'' +
                ", cuit='" + cuit + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", paginaWeb='" + paginaWeb + '\'' +
                ", perfilSocio='" + localidad + '\'' +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                ", fechaBaja=" + fechaBaja +
                ", tipoSocio=" + tipoSocio +
                ", activo=" + activo +
                ", sector=" + sector +
                ", domicilio=" + domicilio +
                '}';
    }
}