package com.poli.arq.software.envios_api.controller;

import com.poli.arq.software.envios_api.model.Envio;
import com.poli.arq.software.envios_api.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/envios")
public class EnviosController {
    @Autowired
    private EnvioRepository envioRepository;

    @GetMapping
    public ResponseEntity<List<Envio>> listarEnvios() {
        return ResponseEntity.ok(envioRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Envio> crearEnvio(@RequestBody Envio envio) {
        return ResponseEntity.ok(envioRepository.save(envio));
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Envio> actualizarEstado(@PathVariable Integer id, @RequestParam String estado) {
        return envioRepository.findById(id)
                .map(e -> {
                    e.setEstado(estado);
                    return ResponseEntity.ok(envioRepository.save(e));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
