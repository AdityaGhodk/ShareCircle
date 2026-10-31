package com.sharecircle.sharecircle.controller;

import com.sharecircle.sharecircle.entity.User;
import com.sharecircle.sharecircle.service.UserService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignupController {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    public SignupController(UserService userService) {
        this.userService = userService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @PostMapping("/signup")
    public String registerUser(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String confirmPassword,
            Model model) {

        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match!");
            return "signup";
        }

        String normalizedEmail = email.trim().toLowerCase();

        if (userService.getUserByEmail(normalizedEmail).isPresent()) {
            model.addAttribute("error", "Email is already registered!");
            return "signup";
        }

        User user = new User();

        user.setFullName(name.trim());
        user.setEmail(normalizedEmail);
        user.setPassword(passwordEncoder.encode(password));

        userService.registerUser(user);

        return "redirect:/login?registered";
    }
}