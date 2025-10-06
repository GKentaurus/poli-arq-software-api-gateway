package com.poli.arq.software.pagos_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pagos", schema = "app")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPago;

    private Integer idPedido;
    private String metodoPago;
    private Double monto;
    private String moneda = "COP";
    private String estado = "pendiente";
    private LocalDateTime fechaPago = LocalDateTime.now();
    private String referenciaTransaccion;
}
