package com.poli.arq.software.pedidos_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pedidos", schema = "app")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    private Integer idCliente;
    private LocalDateTime fechaPedido = LocalDateTime.now();
    private String estado = "pendiente";
    private Double total = 0.0;
}
