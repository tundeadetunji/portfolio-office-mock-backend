package com.inovationware.product.business.data.services;

import com.inovationware.product.business.data.models.Product;

import java.util.List;

public interface ProductServiceJPA {
    Product saveProduct(Product product);

    List<Product> findAll();

    Product findById(Long id);
}
