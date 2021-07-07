package ca.smckinlay.dealership.service.controllers;

import ca.smckinlay.dealership.service.models.ServiceItem;
import ca.smckinlay.dealership.service.models.Status;
import ca.smckinlay.dealership.service.services.ServiceModel;
import ca.smckinlay.dealership.service.util.AttributeNames;
import ca.smckinlay.dealership.service.util.Mappings;
import ca.smckinlay.dealership.service.util.Views;
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
@RequestMapping(Mappings.WORKSHOP)
public class WorkshopController {

    private static final List<Status> statusMessageList = Arrays.asList(Status.values());

    private final ServiceModel serviceModel;

    public WorkshopController(ServiceModel serviceModel) {
        this.serviceModel = serviceModel;
    }

    @GetMapping()
    public String workshop(Model model) {
        model.addAttribute(AttributeNames.BOOKINGS, serviceModel.getAllBookings());
        model.addAttribute(AttributeNames.STATUS_MESSAGE, statusMessageList);
        return Views.WORKSHOP;
    }

    @GetMapping(Mappings.WORKSHOP_ITEM)
    public String workshopItem(@RequestParam String id, Model model, RedirectAttributes redirectAttributes) {
        ServiceItem service = serviceModel.getBooking(id);
        redirectAttributes.addFlashAttribute(AttributeNames.BOOKING, service);
        return Mappings.REDIRECT_WORKSHOP;
    }

    @PostMapping(Mappings.NEW_WORKSHOP_ENTRY)
    public String newEditWorkshop(@Valid @ModelAttribute("service") ServiceItem service, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        service.setDate();

        if(bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
            redirectAttributes.addFlashAttribute(AttributeNames.VALIDATION_ERRORS, errors);
            redirectAttributes.addFlashAttribute(AttributeNames.BOOKING, service);

            return Mappings.REDIRECT_WORKSHOP;
        }

        serviceModel.addUpdateBooking(service);
        redirectAttributes.addFlashAttribute(AttributeNames.BOOKING, service);
        return Mappings.REDIRECT_WORKSHOP;
    }


}
