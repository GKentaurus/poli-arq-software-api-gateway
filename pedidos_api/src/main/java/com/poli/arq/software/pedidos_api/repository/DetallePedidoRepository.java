package com.poli.arq.software.pedidos_api.repository;

import com.poli.arq.software.pedidos_api.model.DetallePedido;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {
    //
}
