package com.poli.arq.software.notificaciones_api.controller;

import com.poli.arq.software.notificaciones_api.model.Notificacion;
import com.poli.arq.software.notificaciones_api.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionesController {
    @Autowired
    private NotificacionRepository notificacionRepository;

    @GetMapping
    public ResponseEntity<List<Notificacion>> listarNotificaciones() {
        return ResponseEntity.ok(notificacionRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Notificacion> enviarNotificacion(@RequestBody Notificacion notificacion) {
        return ResponseEntity.ok(notificacionRepository.save(notificacion));
    }
}
