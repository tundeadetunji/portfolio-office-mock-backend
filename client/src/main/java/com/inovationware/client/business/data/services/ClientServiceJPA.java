package com.inovationware.client.business.data.services;

import com.inovationware.client.business.data.models.Client;

import java.util.List;

public interface ClientServiceJPA {
    Client saveClient(Client client);

    Client findByEmail(String email);

    List<Client> findAll();
}
