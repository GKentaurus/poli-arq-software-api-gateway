package com.poli.arq.software.envios_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "envios", schema = "app")
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEnvio;

    private Integer idPedido;
    private String direccionEnvio;
    private String ciudad;
    private String departamento;
    private String codigoPostal;
    private String estado = "pendiente";
    private String transportadora;
    private LocalDateTime fechaEnvio;
    private LocalDateTime fechaEntrega;
}
