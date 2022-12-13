package com.inovationware.product.business.data.services;

import com.inovationware.product.business.data.models.Product;
import com.inovationware.product.business.data.repositories.ProductRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ProductService implements ProductServiceJPA {

    private final ProductRepository repository;

    @Override
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id).get();
    }
}
