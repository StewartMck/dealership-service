package ca.smckinlay.dealership.service.controllers;

import ca.smckinlay.dealership.service.models.Service;
import ca.smckinlay.dealership.service.models.Status;
import ca.smckinlay.dealership.service.util.Mappings;
import ca.smckinlay.dealership.service.util.Views;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ServiceController {

    private static final Logger log = LoggerFactory.getLogger(ServiceController.class);

    private static final List<Status> statusMessageList = Arrays.asList(Status.values());

    // some mock data
    private static List<Service> serviceList = new ArrayList<>();
    static {
        serviceList.add(new Service("ABC132", "Grand Cherokee", "John Abrahams","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque posuere scelerisque felis, in viverra leo ullamcorper ut. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam venenatis, tellus id faucibus accumsan, lacus metus pharetra nisi, vel rhoncus turpis augue at neque. Phasellus id erat at risus ornare porttitor. Etiam vitae varius dui. Nullam volutpat, metus et egestas bibendum, felis leo mollis odio, sed dignissim massa odio non quam. Fusce dapibus urna sit amet blandit varius.","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque posuere scelerisque felis, in viverra leo ullamcorper ut. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam venenatis, tellus id faucibus accumsan, lacus metus pharetra nisi, vel rhoncus turpis augue at neque. Phasellus id erat at risus ornare porttitor. Etiam vitae varius dui. Nullam volutpat, metus et egestas bibendum, felis leo mollis odio, sed dignissim massa odio non quam. Fusce dapibus urna sit amet blandit varius.", Status.QUEUE));
        serviceList.add(new Service("ABC234", "Cherokee", "Susan Gleece","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque posuere scelerisque felis, in viverra leo ullamcorper ut. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam venenatis, tellus id faucibus accumsan, lacus metus pharetra nisi, vel rhoncus turpis augue at neque. Phasellus id erat at risus ornare porttitor. Etiam vitae varius dui. Nullam volutpat, metus et egestas bibendum, felis leo mollis odio, sed dignissim massa odio non quam. Fusce dapibus urna sit amet blandit varius.","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque posuere scelerisque felis, in viverra leo ullamcorper ut. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam venenatis, tellus id faucibus accumsan, lacus metus pharetra nisi, vel rhoncus turpis augue at neque. Phasellus id erat at risus ornare porttitor. Etiam vitae varius dui. Nullam volutpat, metus et egestas bibendum, felis leo mollis odio, sed dignissim massa odio non quam. Fusce dapibus urna sit amet blandit varius.", Status.COMPLETE));
        serviceList.add(new Service("ABC345", "Wagoneer", "Percy Brahms","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque posuere scelerisque felis, in viverra leo ullamcorper ut. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam venenatis, tellus id faucibus accumsan, lacus metus pharetra nisi, vel rhoncus turpis augue at neque. Phasellus id erat at risus ornare porttitor. Etiam vitae varius dui. Nullam volutpat, metus et egestas bibendum, felis leo mollis odio, sed dignissim massa odio non quam. Fusce dapibus urna sit amet blandit varius.","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque posuere scelerisque felis, in viverra leo ullamcorper ut. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam venenatis, tellus id faucibus accumsan, lacus metus pharetra nisi, vel rhoncus turpis augue at neque. Phasellus id erat at risus ornare porttitor. Etiam vitae varius dui. Nullam volutpat, metus et egestas bibendum, felis leo mollis odio, sed dignissim massa odio non quam. Fusce dapibus urna sit amet blandit varius.", Status.DELAYED));
        serviceList.add(new Service("ABC456", "Rubicon", "Paul Abrahams","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque posuere scelerisque felis, in viverra leo ullamcorper ut. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam venenatis, tellus id faucibus accumsan, lacus metus pharetra nisi, vel rhoncus turpis augue at neque. Phasellus id erat at risus ornare porttitor. Etiam vitae varius dui. Nullam volutpat, metus et egestas bibendum, felis leo mollis odio, sed dignissim massa odio non quam. Fusce dapibus urna sit amet blandit varius.","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque posuere scelerisque felis, in viverra leo ullamcorper ut. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam venenatis, tellus id faucibus accumsan, lacus metus pharetra nisi, vel rhoncus turpis augue at neque. Phasellus id erat at risus ornare porttitor. Etiam vitae varius dui. Nullam volutpat, metus et egestas bibendum, felis leo mollis odio, sed dignissim massa odio non quam. Fusce dapibus urna sit amet blandit varius.", Status.QUEUE));
    }


    @GetMapping(Mappings.SERVICE)
    public String service(Model model) {
        model.addAttribute("vehicles", serviceList);
        model.addAttribute("statusMessageList", statusMessageList);
        log.info("MODEL {}", model);
        log.info("Options {}", statusMessageList);
        return Views.SERVICE;
    }

    @GetMapping(Mappings.SERVICE_ITEM)
    public String serviceItem(@RequestParam String id, Model model, RedirectAttributes redirectAttributes) {
        log.info("The Request param is {}", id);
        Service service = Service.getService(id);
        log.info("FOUND SERVICE, {}", service);
        redirectAttributes.addFlashAttribute("service", service);
        return Mappings.REDIRECT_SERVICES;
    }



}
