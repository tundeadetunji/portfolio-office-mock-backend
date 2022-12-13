package com.inovationware.client.business.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inovationware.client.business.data.models.Client;
import com.inovationware.client.business.data.services.ClientService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.inovationware.domain.data.dto.*;
import com.inovationware.domain.util.serializer.*;

/**
 * this service updates the client's record
 * to reflect how much he/she has spent on
 * our products so far
 */

@Slf4j
@Service
@Data
public class RabbitmqConsumer {
    private final ClientService service;

    public void onProductSale(String paymentDTO) throws JsonProcessingException {
        //update client's record to reflect new payment

        PaymentDTO dto = new PaymentSerializer().deserialize(paymentDTO);
        Client existing = service.findByEmail(dto.getClientEmail());
        if (existing != null){
            existing.setAmountSpentTillDate(existing.getAmountSpentTillDate() + dto.getAmount());
            service.saveClient(existing);
        }
    }
}
