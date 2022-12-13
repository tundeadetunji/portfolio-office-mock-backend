package com.inovationware.product.web.controllers;

import com.inovationware.product.business.data.models.Product;
import com.inovationware.product.business.data.services.ProductService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inovationware.domain.data.dto.*;

import javax.websocket.server.PathParam;

@RestController
@Data
@RequestMapping("/api/v1/product")
public class APIController {
    private final ProductService service;

    //add product
    @PostMapping("/add")
    public ResponseEntity<Object> addProduct(@RequestBody ProductDTO dto){
        //the calling application (likely an Android app)
        //would have verified that the user was authorized
        //and that all values are valid
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveProduct(new ModelMapper().map(dto, Product.class)));
    }

    //view products
    @GetMapping("/")
    public ResponseEntity<Object> getProducts(){
        //the calling application would have verified
        //that the user was authorized
        return ResponseEntity.ok().body(service.findAll());
    }

    //view product
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable Long id){
        //the calling application would have verified
        //that the user was authorized
        Product existing = service.findById(id);
        if (existing == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource with id '" + String.valueOf(id) + "' was not found!");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(existing);
    }

}
