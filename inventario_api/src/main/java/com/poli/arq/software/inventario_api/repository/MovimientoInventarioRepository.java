package com.poli.arq.software.inventario_api.repository;

import com.poli.arq.software.inventario_api.model.MovimientoInventario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface MovimientoInventarioRepository extends JpaRepository<MovimientoInventario, Integer> {
    //
}
