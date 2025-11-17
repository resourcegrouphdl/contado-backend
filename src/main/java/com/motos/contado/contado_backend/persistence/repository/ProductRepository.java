package com.motos.contado.contado_backend.persistence.repository;

import com.motos.contado.contado_backend.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

