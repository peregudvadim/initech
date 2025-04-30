package by.peregud.initech.llc.controller;

import by.peregud.initech.llc.dto.UserDto;
import by.peregud.initech.llc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    public UserController(UserService uService) {
        this.uService = uService;
    }

    private final UserService uService;

    @GetMapping
    public String showUsers(@RequestParam(defaultValue = "1") int page, Model model) {
        List<UserDto> users = uService.findAllPageable(page - 1);
        boolean pagination = uService.showPagination();
        int total = uService.getTotalPages();

        model.addAttribute("page", page);
        model.addAttribute("users", users);
        model.addAttribute("pagination", pagination);
        model.addAttribute("view", "users");
        model.addAttribute("total", total);

        return "users";
    }

    @RequestMapping("/remove/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        if (uService.delete(id)) {
            return "redirect:/users";
        }

        return "exception/data-not-saved";
    }

    @GetMapping("/update-form/{id}")
    public String showUpdateUserForm(@PathVariable("id") int id, Model model) {
        return uService.findById(id)
                .map(user -> {
                    model.addAttribute("user", user);
                    return "update-user";
                })
                .orElse("exception/view-user-not-found");
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, UserDto dto) {
        if (id != dto.getId()) {
            return "error/id-mismatch";
        }

        return uService.update(dto)
                .map(user -> "redirect:/users")
                .orElse("exception/view-data-not-saved");
    }
}
