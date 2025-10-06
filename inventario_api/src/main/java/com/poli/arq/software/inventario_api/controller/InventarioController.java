package com.poli.arq.software.inventario_api.controller;

import com.poli.arq.software.inventario_api.model.Inventario;
import com.poli.arq.software.inventario_api.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {
    @Autowired
    private InventarioRepository inventarioRepository;

    @GetMapping
    public ResponseEntity<List<Inventario>> listarInventario() {
        return ResponseEntity.ok(inventarioRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Inventario> registrarStock(@RequestBody Inventario inventario) {
        return ResponseEntity.ok(inventarioRepository.save(inventario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventario> actualizarStock(@PathVariable Integer id, @RequestBody Inventario inventario) {
        return inventarioRepository.findById(id)
                .map(i -> {
                    inventario.setIdInventario(id);
                    return ResponseEntity.ok(inventarioRepository.save(inventario));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
