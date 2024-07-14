package com.dsi.tp1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dsi.tp1.entities.Consumer;
import com.dsi.tp1.entities.PayementInfo;
import com.dsi.tp1.services.IConsumerServive;

import java.util.List;

@RestController
public class ConsumerController {
    @Autowired
    IConsumerServive consumerService;

    @Autowired
    private Environment env;

    @GetMapping("/test")
    public String test() {
        return "test from : " + env.getProperty("local.server.port");
    }

    @GetMapping("/consumers/{id}")
    public Consumer getConsumerInfo(@PathVariable int id) {
        return consumerService.getInfoConsumer(id);
    }

    @PostMapping("/consumers")
    public void subscribeConsumer(@RequestBody Consumer consumer) {
        consumerService.subscribeConsumer(consumer);
    }

    @GetMapping("/consumers/{id}/cards")
    public List<PayementInfo> getCardsByConsumer(@PathVariable int id) {
        return consumerService.findCardByConsumer(id);
    }
}
