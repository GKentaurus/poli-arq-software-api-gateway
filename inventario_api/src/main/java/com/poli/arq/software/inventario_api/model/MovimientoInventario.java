package com.poli.arq.software.inventario_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "movimientos_inventario", schema = "app")
public class MovimientoInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovimiento;

    private Integer idProducto;
    private String tipoMovimiento; // entrada / salida
    private Integer cantidad;
    private LocalDateTime fecha = LocalDateTime.now();
    private String descripcion;
}