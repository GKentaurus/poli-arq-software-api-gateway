package com.poli.arq.software.notificaciones_api.controller;

import com.poli.arq.software.notificaciones_api.repository.NotificacionRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
@Log4j2
public class HealthController {
    @Autowired
    private NotificacionRepository repo;

    @GetMapping
    public ResponseEntity<String> checkHealth() {
        log.info("Health endpoint checked");
        this.repo.findAll(Pageable.ofSize(1));
        return ResponseEntity.ok("Ok");
    }
}
