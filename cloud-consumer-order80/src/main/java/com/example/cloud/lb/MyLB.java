package com.example.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Sun
 * @version 1.0
 * @date 2022/1/21 19:20
 */
@Service
public class MyLB implements LoadBalancer {

    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    private Integer getAndIncrement() {
        int current, next;
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));
        System.out.println("访问次数：" + next);
        return next;
    }


    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int server = (getAndIncrement() % serviceInstances.size());
        return serviceInstances.get(server);
    }
}
