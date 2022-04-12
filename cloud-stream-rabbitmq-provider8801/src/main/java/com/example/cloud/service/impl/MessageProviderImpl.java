package com.example.cloud.service.impl;

import com.example.cloud.service.IMessageProvider;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author Sun
 * @version 1.0
 * @date 2022/3/19 17:46
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    @Resource(name = "output")
    private MessageChannel messageChannel;


    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        messageChannel.send(MessageBuilder.withPayload(uuid).build());
        System.out.println(uuid);
        return null;
    }
}
