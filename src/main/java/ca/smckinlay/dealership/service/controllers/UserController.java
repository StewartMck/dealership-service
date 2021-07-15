package ca.smckinlay.dealership.service.controllers;

import ca.smckinlay.dealership.service.services.SecurityService;
import ca.smckinlay.dealership.service.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private UserService userService;
    private SecurityService securityService;

    public UserController(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @GetMapping("/login")
    public String login(Model model,String error, String logout) {
        if(error != null) {
            model.addAttribute("error", "Your username and password is invalid!");
        }

        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully");
        }

        return "login";
    }

}
