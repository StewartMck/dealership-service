package ca.smckinlay.dealership.service.controllers;

import ca.smckinlay.dealership.service.models.ServiceItem;
import ca.smckinlay.dealership.service.models.Status;
import ca.smckinlay.dealership.service.models.Vehicle;
import ca.smckinlay.dealership.service.services.ServiceModel;
import ca.smckinlay.dealership.service.services.VehicleModel;
import ca.smckinlay.dealership.service.util.AttributeNames;
import ca.smckinlay.dealership.service.util.Mappings;
import ca.smckinlay.dealership.service.util.Views;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(Mappings.SERVICE)
public class ServiceController {

    private static final Logger log = LoggerFactory.getLogger(ServiceController.class);
    private static final List<Status> statusMessageList = Arrays.asList(Status.values());

    private final ServiceModel serviceModel;
    private final VehicleModel vehicleModel;

    public ServiceController(ServiceModel serviceModel, VehicleModel vehicleModel) {
        this.serviceModel = serviceModel;
        this.vehicleModel = vehicleModel;
    }

    @GetMapping()
    public String service(Model model) {
        model.addAttribute(AttributeNames.BOOKINGS, serviceModel.getAllBookings());
        model.addAttribute(AttributeNames.STATUS_MESSAGE, statusMessageList);
        model.addAttribute(AttributeNames.VEHICLES, vehicleModel.getAllVehicles());
        log.info("ALL VEHICLES {}", vehicleModel.getAllVehicles());
        return Views.SERVICE;
    }

    @GetMapping(Mappings.SERVICE_ITEM)
    public String serviceItem(@RequestParam String id, Model model, RedirectAttributes redirectAttributes) {
        ServiceItem service = serviceModel.getBooking(id);
        log.info("FOUND IN SERVICE_ITEM {}", service);
        redirectAttributes.addFlashAttribute(AttributeNames.BOOKING, service);
        return Mappings.REDIRECT_SERVICES;
    }

    @PostMapping(Mappings.NEW_SERVICE)
    public String newEditService(@Valid @ModelAttribute("service") ServiceItem service,BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        service.setDate();

        if(bindingResult.hasErrors()) {
            log.info("bindingResult {}", bindingResult);
            Map<String, String> errors = new HashMap<>();
            bindingResult.getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
            redirectAttributes.addFlashAttribute(AttributeNames.VALIDATION_ERRORS, errors);
            redirectAttributes.addFlashAttribute(AttributeNames.BOOKING, service);

            return Mappings.REDIRECT_SERVICES;
        }

            serviceModel.addUpdateBooking(service);
            redirectAttributes.addFlashAttribute(AttributeNames.BOOKING, service);
            return Mappings.REDIRECT_SERVICES;
    }

}
