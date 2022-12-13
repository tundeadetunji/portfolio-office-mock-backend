package com.inovationware.domain.util.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.inovationware.domain.data.dto.*;

public class ProductSerializer {
    private final ObjectMapper mapper;

    public ProductSerializer() {
        mapper = new ObjectMapper();
    }

    public String serialize(ProductDTO dto) throws JsonProcessingException {
        return mapper.writeValueAsString(dto);
    }

    public ProductDTO deserialize(String json) throws JsonProcessingException {
        return mapper.readValue(json, ProductDTO.class);
    }
}
