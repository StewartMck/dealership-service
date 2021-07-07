package ca.smckinlay.dealership.service.controllers;

import ca.smckinlay.dealership.service.models.ServiceItem;
import ca.smckinlay.dealership.service.models.Status;
import ca.smckinlay.dealership.service.services.ServiceModel;
import ca.smckinlay.dealership.service.util.AttributeNames;
import ca.smckinlay.dealership.service.util.Mappings;
import ca.smckinlay.dealership.service.util.Views;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

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

}
