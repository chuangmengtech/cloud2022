package com.example.cloud.controller;

import com.example.cloud.entities.CommonResult;
import com.example.cloud.entities.Payment;
import com.example.cloud.lb.MyLB;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author Sun
 * @version 1.0
 * @date 2022/1/8 21:52
 */
@RestController
public class OrderController {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MyLB myLB;

    @Autowired
    private DiscoveryClient discoveryClient;

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";


    @PostMapping("/consumer/payment/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult getPaymentById2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult(444, "操作失败！");
        }
    }

    @GetMapping("/consumer/payment/port")
    @ResponseBody
    public String getServerPort() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        return restTemplate.getForObject(myLB.instance(instances).getUri() + "/payment/port", String.class);
    }

}
