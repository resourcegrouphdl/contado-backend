package com.motos.contado.contado_backend.service.impl;



import com.motos.contado.contado_backend.persistence.entity.Product;
import com.motos.contado.contado_backend.persistence.repository.ProductRepository;
import com.motos.contado.contado_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductSerciceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Page<Product> findAll(Pageable pageable) {
        return  productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findOneById(Long productId) {
        return productRepository.findById(productId);
    }





}
