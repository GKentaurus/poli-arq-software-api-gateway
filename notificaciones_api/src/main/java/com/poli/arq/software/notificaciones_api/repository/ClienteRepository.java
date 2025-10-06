package com.poli.arq.software.notificaciones_api.repository;

import com.poli.arq.software.notificaciones_api.model.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    //
}
