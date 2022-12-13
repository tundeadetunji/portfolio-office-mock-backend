package com.inovationware.product.business.messaging;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Data
public class RabbitmqConsumer {

    public void onProductSale(String message){
    }
}
