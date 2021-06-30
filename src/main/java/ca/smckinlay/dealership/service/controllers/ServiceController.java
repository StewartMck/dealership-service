package ca.smckinlay.dealership.service.controllers;

import ca.smckinlay.dealership.service.models.Service;
import ca.smckinlay.dealership.service.models.Status;
import ca.smckinlay.dealership.service.util.Mappings;
import ca.smckinlay.dealership.service.util.Views;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ServiceController {

    // some mock data
    private static List<Service> serviceList = new ArrayList<>();
    static {
        serviceList.add(new Service("ABC132", "Grand Cherokee", "John Abrahams", Status.QUEUE));
        serviceList.add(new Service("ABC234", "Cherokee", "Susan Gleece", Status.QUEUE));
        serviceList.add(new Service("ABC345", "Wagoneer", "Percy Brahms", Status.QUEUE));
        serviceList.add(new Service("ABC456", "Rubicon", "Paul Abrahams", Status.QUEUE));
    }


    @GetMapping(Mappings.SERVICE)
    public String service(Model model) {
        model.addAttribute("vehicles", serviceList);
        return Views.SERVICE;
    }


}
