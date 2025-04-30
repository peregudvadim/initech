package by.peregud.initech.llc.controller;

import by.peregud.initech.llc.dto.UserCreateDto;
import by.peregud.initech.llc.exception.UserExistException;
import by.peregud.initech.llc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {


    private final UserService uService;

    public AuthController(UserService uService) {
        this.uService = uService;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/registration")
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerNewUser(UserCreateDto createDto) throws UserExistException {
        uService.save(createDto);
        return "login";
    }
}