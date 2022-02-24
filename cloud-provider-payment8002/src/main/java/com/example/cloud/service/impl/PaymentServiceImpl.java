package com.example.cloud.service.impl;

import com.example.cloud.dao.PaymentDao;
import com.example.cloud.entities.Payment;
import com.example.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * @author Sun
 * @version 1.0
 * @date 2022/1/8 16:02
 */
@Service
public class PaymentServiceImpl implements PaymentService {


    private final PaymentDao paymentDao;

    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
