package com.poli.arq.software.catalogo_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "productos", schema = "app")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    private String nombre;
    private String descripcion;
    private Double precio;
    private String categoria;
    private Boolean disponible = true;

    private LocalDateTime fechaCreacion = LocalDateTime.now();
}
