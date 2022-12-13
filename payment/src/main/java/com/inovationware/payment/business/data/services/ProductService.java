package com.inovationware.payment.business.data.services;

import com.inovationware.payment.business.data.models.Client;
import com.inovationware.payment.business.data.models.Product;
import com.inovationware.payment.business.data.repositories.ClientRepository;
import com.inovationware.payment.business.data.repositories.ProductRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Data
@Transactional
public class ProductService implements ProductServiceJPA {
    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
