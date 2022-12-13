package com.inovationware.domain.util.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.inovationware.domain.data.dto.*;

public class PaymentSerializer {
    private final ObjectMapper mapper;

    public PaymentSerializer() {
        mapper = new ObjectMapper();
    }

    public String serialize(PaymentDTO dto) throws JsonProcessingException {
        return mapper.writeValueAsString(dto);
    }

    public PaymentDTO deserialize(String json) throws JsonProcessingException {
        return mapper.readValue(json, PaymentDTO.class);
    }
}
