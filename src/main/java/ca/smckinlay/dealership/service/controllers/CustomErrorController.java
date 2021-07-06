package ca.smckinlay.dealership.service.controllers;

import ca.smckinlay.dealership.service.services.HTTPStatusErrorService;
import ca.smckinlay.dealership.service.util.AttributeNames;
import ca.smckinlay.dealership.service.util.Mappings;
import ca.smckinlay.dealership.service.util.Views;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    private static final Logger log = LoggerFactory.getLogger(CustomErrorController.class);
    private final HTTPStatusErrorService httpStatusErrorService;

    @Autowired
    public CustomErrorController(HTTPStatusErrorService httpStatusErrorService) {
        this.httpStatusErrorService = httpStatusErrorService;
    }

    @GetMapping(Mappings.ERROR)
    public String handleError(HttpServletRequest request, Model model){

        int statusCode = (Integer)request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        model.addAttribute(AttributeNames.STATUS_CODE, statusCode);
        model.addAttribute(AttributeNames.HTTP_STATUS_ERROR,httpStatusErrorService.getHTTPStatusMsg(statusCode));

        log.error("THIS IS AN ERROR, {}", statusCode);
        return "error";
    }

}
