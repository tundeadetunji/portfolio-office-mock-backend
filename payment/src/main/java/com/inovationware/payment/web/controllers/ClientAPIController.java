package com.inovationware.payment.web.controllers;

import com.inovationware.payment.business.data.models.Client;
import com.inovationware.payment.business.data.services.ClientService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@RequestMapping("/api/v1/client")
public class ClientAPIController {

    private final ClientService service;

    //view all clients
    @GetMapping("/")
    public ResponseEntity<Object> getClients(){
        return ResponseEntity.ok().body(service.findAll());
    }

    //view a client
    @GetMapping("/{email}")
    public ResponseEntity<Object> getClient(@PathVariable String email){
        Client existing = service.findByEmail(email);
        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client with email '" + email + "' was not found!");
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(existing);
    }
}
