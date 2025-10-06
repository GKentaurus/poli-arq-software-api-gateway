package com.poli.arq.software.pagos_api.repository;

import com.poli.arq.software.pagos_api.model.Pago;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface PagoRepository extends JpaRepository<Pago, Integer> {
    //
}
