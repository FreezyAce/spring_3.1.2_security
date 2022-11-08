package FreezyAce.Spring_312.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AuthController {
    // Login form
    @RequestMapping("/login")
    public String login() {
        return "/login/login";
    }
}
