package com.example.cloud.dao;

import com.example.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Sun
 * @version 1.0
 * @date 2022/1/8 15:45
 */
@Mapper
public interface PaymentDao {

    /**
     * 写操作
     *
     * @param payment 入参
     * @return 结果
     */
    int create(Payment payment);

    /**
     * 根据ID查询
     *
     * @param id id
     * @return 结果
     */
    Payment getPaymentById(@Param("id") Long id);
}
