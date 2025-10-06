package com.poli.arq.software.pedidos_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "detalles_pedido", schema = "app")
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalle;

    private Integer idPedido;
    private Integer idProducto;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;
}
