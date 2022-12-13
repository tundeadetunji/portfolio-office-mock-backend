package com.inovationware.payment.business.data.services;

import com.inovationware.payment.business.data.models.Payment;

import java.util.List;

public interface PaymentServiceJPA {
    Payment savePayment(Payment payment);

    List<Payment> findAll();

    Payment findById(Long id);

    List<Payment> findByClient(String email);

}
