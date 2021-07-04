package ca.smckinlay.dealership.service.controllers;

import ca.smckinlay.dealership.service.models.ServiceItem;
import ca.smckinlay.dealership.service.models.Status;
import ca.smckinlay.dealership.service.services.ServiceModel;
import ca.smckinlay.dealership.service.util.Mappings;
import ca.smckinlay.dealership.service.util.Views;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(Mappings.SERVICE)
public class ServiceController {

    private static final Logger log = LoggerFactory.getLogger(ServiceController.class);
    private static final List<Status> statusMessageList = Arrays.asList(Status.values());

    private final ServiceModel serviceModel;

    public ServiceController(ServiceModel serviceModel) {
        this.serviceModel = serviceModel;
    }

    @GetMapping()
    public String service(Model model) {
        model.addAttribute("vehicles", serviceModel.getAllServices());
        model.addAttribute("statusMessageList", statusMessageList);
        return Views.SERVICE;
    }

    @GetMapping(Mappings.SERVICE_ITEM)
    public String serviceItem(@RequestParam String id, Model model, RedirectAttributes redirectAttributes) {
        ServiceItem service = serviceModel.getService(id);
        redirectAttributes.addFlashAttribute("service", service);
        return Mappings.REDIRECT_SERVICES;
    }

    @PostMapping(Mappings.NEW_SERVICE)
    public String newEditService(@ModelAttribute("service") ServiceItem service, RedirectAttributes redirectAttributes) {
        serviceModel.addUpdateService(service);
        redirectAttributes.addFlashAttribute("service", service);
        return Mappings.REDIRECT_SERVICES;
    }

}
