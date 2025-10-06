package com.poli.arq.software.envios_api.repository;

import com.poli.arq.software.envios_api.model.Envio;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface EnvioRepository extends JpaRepository<Envio, Integer> {
    //
}
