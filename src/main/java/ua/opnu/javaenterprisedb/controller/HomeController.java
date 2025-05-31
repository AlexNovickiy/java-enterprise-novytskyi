package ua.opnu.javaenterprisedb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homePage(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());



        return "home";
    }
}