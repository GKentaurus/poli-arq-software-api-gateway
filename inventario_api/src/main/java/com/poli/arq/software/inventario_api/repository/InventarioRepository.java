package com.poli.arq.software.inventario_api.repository;

import com.poli.arq.software.inventario_api.model.Inventario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
    //
}
