package ca.smckinlay.dealership.service.controllers;

import ca.smckinlay.dealership.service.models.ServiceItem;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
@Slf4j
public class WebSocketController {

    private static final Logger log = LoggerFactory.getLogger(WebSocketController.class);

    @PostConstruct
    public void init() {
        log.info("WEBSOCKET CONTROLLER INITIALIZED");
    }

    @MessageMapping("/update")
    @SendTo("/status/update")
    public String updateStatus(ServiceItem serviceItem) throws Exception {
        log.info("RUNNING UPDATE STATUS");
        return "serviceItem;";
    }

}
