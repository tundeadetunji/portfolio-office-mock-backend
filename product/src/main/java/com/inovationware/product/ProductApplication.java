package com.inovationware.product;

import com.inovationware.product.business.data.models.Product;
import com.inovationware.product.business.data.services.ProductServiceJPA;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
        log.info("* InMemory Database - http://localhost:8082/h2-console (username: sa, password:)");
    }


    private InitialData data = new InitialData();
    @Bean
    CommandLineRunner commandLineRunner(ProductServiceJPA productService){
        return args -> {
            //products
            productService.saveProduct(data.vsat);
            productService.saveProduct(data.msat);
            productService.saveProduct(data.mlink);
        };
    }

}


class InitialData{
    Product vsat;
    Product msat;
    Product mlink;

    public InitialData() {
        vsat = new Product();
        vsat.setName("VSAT-1");
        vsat.setDescription("VSAT-1");

        msat = new Product();
        msat.setName("VSAT-2");
        msat.setDescription("VSAT-2");

        mlink = new Product();
        mlink.setName("VSAT-3");
        mlink.setDescription("VSAT-3");

    }
}
