package com.inovationware.payment.business.data.services;

import com.inovationware.payment.business.data.models.Client;
import com.inovationware.payment.business.data.repositories.ClientRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ClientService implements ClientServiceJPA {

    private final ClientRepository repository;

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Client findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Client saveClient(Client client) {
        return repository.save(client);
    }
}
