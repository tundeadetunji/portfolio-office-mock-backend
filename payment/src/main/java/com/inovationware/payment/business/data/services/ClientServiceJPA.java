package com.inovationware.payment.business.data.services;

import com.inovationware.payment.business.data.models.Client;
import com.inovationware.payment.business.data.models.Payment;

import java.util.List;

public interface ClientServiceJPA {
    List<Client> findAll();

    Client findByEmail(String email);

    Client saveClient(Client client);

}
