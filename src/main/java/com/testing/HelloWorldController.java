package com.testing;

import static org.slf4j.LoggerFactory.getLogger;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private static final Logger LOG = getLogger(HelloWorldController.class.getName());

    public static final String MESSAGE_KEY = "message";

    @GetMapping(path = "/helloworld")
    public Map<String, String> helloWorld() throws UnknownHostException {
        return getResponse();
    }

    private Map<String, String> getResponse() throws UnknownHostException {
        Map<String, String> response = new HashMap<>();
        response.put(MESSAGE_KEY, "hello world");
        LOG.info("Returning {}", response);
        return response;
    }

}
