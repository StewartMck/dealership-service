package ca.smckinlay.dealership.service.controllers;

import ca.smckinlay.dealership.service.util.Mappings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    public static final Logger log = LoggerFactory.getLogger(ErrorController.class);

//    @ResponseBody
    @RequestMapping(Mappings.ERROR)
    public String handleError(HttpServletRequest request){

        int statusCode = (Integer)request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        switch (statusCode) {
            case 404:
                model.addAttribute("statusCode", statusCode);
                model.addAttribute("statusMsg", "Sorry, but the page was not found");
                return "error";
            case 500:
                model.addAttribute()
        }



        log.error("THIS IS AN ERROR, {}", statusCode);
        return "error";
    }

}
