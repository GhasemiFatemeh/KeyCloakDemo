package com.example.demo.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OAuth2Controller {

    @GetMapping("/login")
    public String login() {
        return "redirect:/oauth2/code/keycloak";
    }

    @GetMapping("/")
    public String index(@AuthenticationPrincipal OAuth2User oauth2User, Model model) {
        model.addAttribute("username", oauth2User.getName());
        return "index";
    }
}
