package com.poli.arq.software.pedidos_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "clientes", schema = "app")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;
    private String ciudad;
    private LocalDateTime fechaRegistro = LocalDateTime.now();
}
