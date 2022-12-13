package com.inovationware.payment.business.data.services;

import com.inovationware.payment.business.data.models.Payment;
import com.inovationware.payment.business.data.repositories.PaymentRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class PaymentService implements PaymentServiceJPA {

    private final PaymentRepository repository;

    @Override
    public Payment savePayment(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public List<Payment> findAll() {
        return repository.findAll();
    }

    @Override
    public Payment findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Payment> findByClient(String email) {
        return repository.findByClientEmail(email);
    }
}
