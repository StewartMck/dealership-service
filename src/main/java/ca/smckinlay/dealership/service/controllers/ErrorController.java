package ca.smckinlay.dealership.service.controllers;

import ca.smckinlay.dealership.service.services.HTTPStatusErrorService;
import ca.smckinlay.dealership.service.services.HTTPStatusErrorServiceImpl;
import ca.smckinlay.dealership.service.util.AttributeNames;
import ca.smckinlay.dealership.service.util.Mappings;
import ca.smckinlay.dealership.service.util.Views;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    private static final Logger log = LoggerFactory.getLogger(ErrorController.class);
    private final HTTPStatusErrorService httpStatusErrorService;

    @Autowired
    public ErrorController(HTTPStatusErrorService httpStatusErrorService) {
        this.httpStatusErrorService = httpStatusErrorService;
    }

    //    @ResponseBody
    @RequestMapping(Mappings.ERROR)
    public ModelAndView handleError(HttpServletRequest request){

        int statusCode = (Integer)request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        ModelAndView errorPage = new ModelAndView(Views.ERROR);
        errorPage.addObject(AttributeNames.STATUS_CODE, statusCode);
        errorPage.addObject(AttributeNames.STATUS_MESSAGE,httpStatusErrorService.getHTTPStatusMsg(statusCode));

        log.error("THIS IS AN ERROR, {}", statusCode);
        return errorPage;
    }

}
