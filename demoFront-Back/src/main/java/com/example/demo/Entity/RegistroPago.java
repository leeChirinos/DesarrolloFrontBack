/*package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "registrospagos")
public class RegistroPago implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idRegistroPago;

    @Column(name="fechaCuotaSocio")
    @Temporal(TemporalType.DATE)
    private Date fechaCuotaSocio;

    @Column(name="montoCuotaSocio")
    private String montoCuotaSocio;

    public RegistroPago() {
    }

    public RegistroPago(long idRegistroPago, Date fechaCuotaSocio, String montoCuotaSocio) {
        this.idRegistroPago = idRegistroPago;
        this.fechaCuotaSocio = fechaCuotaSocio;
        this.montoCuotaSocio = montoCuotaSocio;
    }

    public long getIdRegistroPago() {
        return idRegistroPago;
    }

    public void setIdRegistroPago(long idRegistroPago) {
        this.idRegistroPago = idRegistroPago;
    }

    public Date getFechaCuotaSocio() {
        return fechaCuotaSocio;
    }

    public void setFechaCuotaSocio(Date fechaCuotaSocio) {
        this.fechaCuotaSocio = fechaCuotaSocio;
    }

    public String getMontoCuotaSocio() {
        return montoCuotaSocio;
    }

    public void setMontoCuotaSocio(String montoCuotaSocio) {
        this.montoCuotaSocio = montoCuotaSocio;
    }

    @Override
    public String toString() {
        return "RegistroPago{" +
                "idRegistroPago=" + idRegistroPago +
                ", fechaCuotaSocio=" + fechaCuotaSocio +
                ", montoCuotaSocio='" + montoCuotaSocio + '\'' +
                '}';
    }
}*/
