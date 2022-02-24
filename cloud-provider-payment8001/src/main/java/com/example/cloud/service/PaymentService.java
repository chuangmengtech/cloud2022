package com.example.cloud.service;

import com.example.cloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Sun
 */
public interface PaymentService {
    /**
     * save
     *
     * @param payment 1
     * @return 结果
     */
    int create(Payment payment);

    /**
     * 查询
     *
     * @param id id
     * @return 结果
     */
    Payment getPaymentById(@Param("id") Long id);
}
