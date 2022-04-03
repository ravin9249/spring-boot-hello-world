package com.testing;

import static org.slf4j.LoggerFactory.getLogger;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloCountry {

    private static final Logger LOG = getLogger(HelloWorldController.class.getName());

    public static final String MESSAGE_KEY = "message";
    public static final String IP_KEY = "ip";

    
    @GetMapping(path = "/country")
    public Map<String, String> helloCountry() throws UnknownHostException {
        return getResponse();
    }

    private Map<String, String> getResponse() throws UnknownHostException {
        String ip = InetAddress.getLocalHost().getHostAddress();
        Map<String, String> response = new HashMap<>();
        response.put(MESSAGE_KEY, "Hello from " + ip + ".");

/*
        try (java.util.Scanner s = new java.util.Scanner(new java.net.URL("https://api.ip2location.com/v2/?ip=8.8.8.8&key=7ETML2IMSO&package=WS1&format=json&lang=en").openStream(), "UTF-8").useDelimiter("\\A")) {
            System.out.println(s.next());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
*/
        LOG.info("Returning {}", response);
        return response;
    }

}
