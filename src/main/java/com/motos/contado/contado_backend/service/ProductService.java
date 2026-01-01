package com.motos.contado.contado_backend.service;

import java.util.List;
import java.util.Optional;

import com.motos.contado.contado_backend.persistence.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {

    Page<Product> findAll(Pageable pageable);

    Optional<Product> findOneById(Long productId);

    // Método de conveniencia para obtener todos los productos como lista
    default List<Product> findAll() {
        return findAll(Pageable.unpaged()).getContent();
    }
}
