package by.peregud.initech.llc.controller;


import by.peregud.initech.llc.dto.EmployeeCreateDto;
import by.peregud.initech.llc.dto.EmployeeDto;
import by.peregud.initech.llc.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService eService;

    public EmployeeController(EmployeeService eService) {
        this.eService = eService;
    }


    @GetMapping
    public String showEmployees(@RequestParam(defaultValue = "1") int page, Model model) {
        List<EmployeeDto> employees = eService.findAllPageable(page - 1);
        boolean pagination = eService.showPagination();
        int total = eService.getTotalPages();

        model.addAttribute("page", page);
        model.addAttribute("employees", employees);
        model.addAttribute("pagination", pagination);
        model.addAttribute("view", "employees");
        model.addAttribute("total", total);

        return "employees";
    }

    @GetMapping("/add-form")
    public String showAddEmployeeForm() {
        return "create-employee";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute EmployeeCreateDto employeeCreateDto) {
        return eService.save(employeeCreateDto)
                .map(employee -> "redirect:/employees/" + employee.getId())
                .orElse("exception/data-not-saved");
    }

    @RequestMapping("/remove/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        if (eService.delete(id)) {
            return "redirect:/employees";
        }

        return "exception/data-not-saved";
    }

    @GetMapping("/update-form/{id}")
    public String showUpdateEmployeeForm(@PathVariable("id") int id, Model model) {
        return eService.findById(id)
                .map(employee -> {
                    model.addAttribute("employee", employee);
                    return "update-employee";
                })
                .orElse("exception/employee-not-found");
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") int id, @ModelAttribute EmployeeDto dto) {
        if (id != dto.getId()) {
            return "error/id-mismatch";
        }

        return eService.update(dto)
                .map(employee -> "redirect:/employees/" + employee.getId())
                .orElse("exception/data-not-saved");
    }
}
