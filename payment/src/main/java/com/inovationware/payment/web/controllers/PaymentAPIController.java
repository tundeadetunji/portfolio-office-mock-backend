package com.inovationware.payment.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inovationware.payment.business.data.models.Payment;
import com.inovationware.payment.business.data.services.PaymentService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inovationware.domain.data.dto.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static com.inovationware.payment.business.messaging.RabbitmqConfig.EXCHANGE_NAME;

import com.inovationware.domain.util.serializer.*;

@RestController
@RequestMapping("/api/v1/payment")
@Data
public class PaymentAPIController {

    private final PaymentService service;
    private final RabbitTemplate rabbitTemplate;

    //record payment
    @PostMapping("/add")
    public ResponseEntity<Object> addPayment(@RequestBody PaymentDTO dto) throws JsonProcessingException {

        /*
            the calling application (likely an Android app)
            would have verified that the user was authorized
            and that all values are valid
        */


        //message client service
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "client.messages", new PaymentSerializer().serialize(dto));

        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "product.messages", dto.getClientEmail());


        return ResponseEntity.status(HttpStatus.CREATED).body(service.savePayment(new ModelMapper().map(dto, Payment.class)));
    }


    //view payments
    @GetMapping("/")
    public ResponseEntity<Object> getPayments(){

        //the calling application would have verified
        //that the user was authorized

        return ResponseEntity.ok().body(service.findAll());

    }


    //view payment by id
    @GetMapping("/{id}")
    public ResponseEntity<Object> getPaymentById(@PathVariable Long id){

        //the calling application would have verified
        //that the user was authorized

        Payment existing = service.findById(id);
        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Payment with id '" + String.valueOf(id) + "' was not found!");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(existing);
    }


    //view payment by client('s email)
    @GetMapping("/client")
    public ResponseEntity<Object> getPaymentByClient(@RequestParam String email){

        //the calling application would have verified
        //that the user was authorized

        return ResponseEntity.ok().body(service.findByClient(email));
    }
}
