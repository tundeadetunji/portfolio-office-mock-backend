package com.inovationware.client;

import com.inovationware.client.business.data.models.Client;
import com.inovationware.client.business.data.services.ClientService;
import com.inovationware.client.business.data.services.ClientServiceJPA;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
        log.info("* InMemory Database - http://localhost:8081/h2-console (username: sa, password:)");
    }


    private InitialData data = new InitialData();
    @Bean
    CommandLineRunner commandLineRunner(ClientService clientService){
        return args -> {
            //clients
            clientService.saveClient(data.lagos_fiber_optics);
            clientService.saveClient(data.opt_sat);
        };
    }

}

class InitialData{
    Client lagos_fiber_optics;
    Client opt_sat;

    public InitialData() {
        lagos_fiber_optics = new Client();
        lagos_fiber_optics.setName("Lagos Fiber Optics Corp.");
        lagos_fiber_optics.setDescription("Our only client from Lagos Island!");
        lagos_fiber_optics.setPhone("01-222-444-22");
        lagos_fiber_optics.setEmail("rep@lfo.com");
        lagos_fiber_optics.setAddress("Lagos Island");
        lagos_fiber_optics.setAmountSpentTillDate(0.00);

        opt_sat = new Client();
        opt_sat.setName("Options Sat Link");
        opt_sat.setDescription("Largest retailer from the south.");
        opt_sat.setPhone("0803-225-7788");
        opt_sat.setEmail("admin@optsat.com");
        opt_sat.setAddress("Lagos Mainland");
        opt_sat.setAmountSpentTillDate(0.00);
    }
}
