package com.inovationware.payment.business.data.models;

import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String clientEmail;

    @Column(nullable = false)
    private Long productId;

    @Column
    private String paymentDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(System.currentTimeMillis()));

    @Column(nullable = false)
    private Integer duration;

    @Column(nullable = false, length = 4000)
    private String details;

    @Column(nullable = false)
    private Double amount;
}
