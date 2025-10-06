package com.poli.arq.software.inventario_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "inventario", schema = "app")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInventario;

    private Integer idProducto;
    private Integer cantidadDisponible;
    private String ubicacion;
    private LocalDateTime ultimaActualizacion = LocalDateTime.now();
}