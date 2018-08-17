package io.pivotal.cf.circuitbreakerdemo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MessageService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackMessage")
    public Message remoteMessage() {
        return restTemplate.getForObject("https://workshop/", Message.class);
    }

    private Message fallbackMessage() {
        return new Message("Oh no, it's broken!");
    }

}
