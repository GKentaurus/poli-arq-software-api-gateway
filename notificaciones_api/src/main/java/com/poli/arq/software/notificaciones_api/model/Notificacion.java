package com.poli.arq.software.notificaciones_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notificaciones", schema = "app")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNotificacion;

    private Integer idUsuario;
    private String tipo;
    private String mensaje;
    private String canal; // email / sms / push
    private String estado = "pendiente";
    private LocalDateTime fechaEnvio = LocalDateTime.now();
}
