package com.inovationware.payment;

import com.inovationware.payment.business.data.models.Client;
import com.inovationware.payment.business.data.models.Product;
import com.inovationware.payment.business.data.services.ClientService;
import com.inovationware.payment.business.data.services.ClientServiceJPA;
import com.inovationware.payment.business.data.services.ProductService;
import com.inovationware.payment.business.data.services.ProductServiceJPA;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class PaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
        log.info("* InMemory Database - http://localhost:8080/h2-console (username: sa, password:)");

    }

    private InitialData data = new InitialData();
    @Bean
    CommandLineRunner commandLineRunner(ProductService productService, ClientService clientService){
        return args -> {
            //clients
            clientService.saveClient(data.lagos_fiber_optics);
            clientService.saveClient(data.opt_sat);
            //products
            productService.saveProduct(data.vsat);
            productService.saveProduct(data.msat);
            productService.saveProduct(data.mlink);
        };
    }

}

class InitialData{
    Client lagos_fiber_optics;
    Client opt_sat;
    Product vsat;
    Product msat;
    Product mlink;

    public InitialData() {
        lagos_fiber_optics = new Client();
        lagos_fiber_optics.setName("Lagos Fiber Optics Corp.");
        lagos_fiber_optics.setDescription("Our only client from Lagos Island!");
        lagos_fiber_optics.setPhone("01-222-444-22");
        lagos_fiber_optics.setEmail("rep@lfo.com");
        lagos_fiber_optics.setAddress("Lagos Island");

        opt_sat = new Client();
        opt_sat.setName("Options Sat Link");
        opt_sat.setDescription("Largest retailer from the south.");
        opt_sat.setPhone("0803-225-7788");
        opt_sat.setEmail("admin@optsat.com");
        opt_sat.setAddress("Lagos Mainland");

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
