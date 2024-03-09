package com.example.demo.models;

import jakarta.persistence.*;


@Entity
@Table(name = "simulacion")
public class SimulacionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private Long cupoAprobado;
    private String tipoTarjeta;
    private String tasa;
    private Long salario;
    private Long clienteId;

    public SimulacionModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCupoAprobado() {
        return cupoAprobado;
    }

    public void setCupoAprobado(Long cupoAprobado) {
        this.cupoAprobado = cupoAprobado;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getTasa() {
        return tasa;
    }

    public void setTasa(String tasa) {
        this.tasa = tasa;
    }

    public Long getSalario() {
        return salario;
    }

    public void setSalario(Long salario) {
        this.salario = salario;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}


