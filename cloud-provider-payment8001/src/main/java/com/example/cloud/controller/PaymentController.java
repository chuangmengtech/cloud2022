package com.example.cloud.controller;

import com.example.cloud.entities.CommonResult;
import com.example.cloud.entities.Payment;
import com.example.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Sun
 * @version 1.0
 * @date 2022/1/8 16:04
 */
@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果集：{}", result);
        if (result > 0) {
            return new CommonResult<>(200, "插入结果集成功,serverPort:" + serverPort, result);
        } else {
            return new CommonResult<>(200, "插入结果集失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("*****查询结果集：{}", result);
        if (result != null) {
            return new CommonResult<>(200, "查询结果集,serverPort:" + serverPort, result);
        } else {
            return new CommonResult<>(200, "查询结果集失败", null);
        }
    }


    @GetMapping("/payment/getServer")
    public void setDiscoveryClient() {
        List<String> services = discoveryClient.getServices();
        System.out.println("services = " + services);
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        System.out.println("instances = " + instances);
    }


    @GetMapping("/payment/port")
    public String getServerPort() {
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // 业务逻辑处理正确，但是需要耗费3秒钟
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
