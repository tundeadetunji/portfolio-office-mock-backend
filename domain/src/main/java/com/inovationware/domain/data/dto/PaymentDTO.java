package com.inovationware.domain.data.dto;

import lombok.Data;

@Data
public class PaymentDTO {
    private String clientEmail;

    private Long productId;

    private Integer duration;

    private String details;

    private Double amount;
}
