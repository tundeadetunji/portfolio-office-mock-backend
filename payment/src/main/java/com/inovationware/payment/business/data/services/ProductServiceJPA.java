package com.inovationware.payment.business.data.services;

import com.inovationware.payment.business.data.models.Client;
import com.inovationware.payment.business.data.models.Product;

public interface ProductServiceJPA {
    Product findById(Long id);

    Product saveProduct(Product product);
}
