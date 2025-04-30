package by.peregud.initech.llc.controller;


import by.peregud.initech.llc.dto.DepartmentCreateDto;
import by.peregud.initech.llc.dto.DepartmentDto;
import by.peregud.initech.llc.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public String showDepartments(Model model) {
        List<DepartmentDto> departments = departmentService.findAll();
        model.addAttribute("departments", departments);
        return "departments";
    }

    @GetMapping("/add-form")
    public String showAddDepartmentForm() {
        return "create-department";
    }

    @PostMapping("/add")
    public String addDepartment(@ModelAttribute DepartmentCreateDto departmentCreateDto) {
        return departmentService.save(departmentCreateDto)
                .map(dep -> "redirect:/departments")
                .orElse("exception/data-not-saved");
    }
}
