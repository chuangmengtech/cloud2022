package com.example.cloud.controller;

import com.example.cloud.service.IMessageProvider;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sun
 * @version 1.0
 * @date 2022/3/19 17:49
 */
@RestController
public class SendMessageController {

    @Autowired
    private IMessageProvider messageProvider;

    @GetMapping("/send")
    public void send(){
        messageProvider.send();
    }

}
