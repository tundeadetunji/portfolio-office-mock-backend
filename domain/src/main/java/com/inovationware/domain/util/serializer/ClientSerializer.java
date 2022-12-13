package com.inovationware.domain.util.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.inovationware.domain.data.dto.*;

public class ClientSerializer {
    private final ObjectMapper mapper;

    public ClientSerializer() {
        mapper = new ObjectMapper();
    }

    public String serialize(ClientDTO dto) throws JsonProcessingException {
        return mapper.writeValueAsString(dto);
    }

    public ClientDTO deserialize(String json) throws JsonProcessingException {
        return mapper.readValue(json, ClientDTO.class);
    }
}
