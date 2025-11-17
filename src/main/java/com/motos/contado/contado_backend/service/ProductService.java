package com.motos.contado.contado_backend.service;

import java.util.Optional;

import com.motos.contado.contado_backend.persistence.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {

    Page<Product> findAll(Pageable pageable);

    Optional<Product> findOneById(Long productId);

}
