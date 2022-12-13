package com.inovationware.domain.data.dto;

import lombok.Data;

@Data
public class AddProductToClientDTO {
    private String clientEmail;

    private Long productId;
}
