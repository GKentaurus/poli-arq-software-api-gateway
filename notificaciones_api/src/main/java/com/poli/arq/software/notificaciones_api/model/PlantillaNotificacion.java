package com.poli.arq.software.notificaciones_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "plantillas_notificacion", schema = "app")
public class PlantillaNotificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlantilla;

    private String nombre;
    private String asunto;
    private String contenido;
    private String canal;
    private Boolean activo = true;
}
