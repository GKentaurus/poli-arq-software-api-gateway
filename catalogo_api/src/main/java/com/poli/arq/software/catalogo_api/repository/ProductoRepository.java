package com.poli.arq.software.catalogo_api.repository;

import com.poli.arq.software.catalogo_api.model.Producto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    //
}
