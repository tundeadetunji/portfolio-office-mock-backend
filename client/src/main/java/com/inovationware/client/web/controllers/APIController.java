package com.inovationware.client.web.controllers;

import com.inovationware.client.business.data.models.Client;
import com.inovationware.client.business.data.services.ClientService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inovationware.domain.data.dto.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/v1/client")
@Data
public class APIController {

    private final ClientService service;

    //view a client
    @GetMapping("/{email}")
    public ResponseEntity<Object> getClient(@PathVariable String email){

        Client existing = service.findByEmail(email);

        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(existing);
    }


    //view all client
    @GetMapping("/")
    public ResponseEntity<Object> getClients(){
        return ResponseEntity.ok().body(service.findAll());
    }


    //add a client
    @PostMapping("/add")
    public ResponseEntity<Object> addClient(@RequestBody ClientDTO dto) {
        //check if the email already exists, if not, don't allow duplicate
        if (service.findByEmail(dto.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Client with email '" + dto.getEmail() + "' already exists,\nchoose another email and try again.");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveClient(new ModelMapper().map(dto, Client.class)));
    }


}
