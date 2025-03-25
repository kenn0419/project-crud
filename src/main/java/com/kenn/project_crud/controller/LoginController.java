package com.kenn.project_crud.controller;

import com.kenn.project_crud.dto.request.LoginRequestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        model.addAttribute("loginRequest", loginRequestDTO);

        return "login";
    }
}
