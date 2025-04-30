package by.peregud.initech.llc.controller;
import by.peregud.initech.llc.dto.ContractCreateDto;
import by.peregud.initech.llc.dto.ContractDto;
import by.peregud.initech.llc.service.ContractService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/contracts")
public class ContractController {

    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping
    public String showContracts(Model model) {
        List<ContractDto> contracts = contractService.findAll();
        model.addAttribute("contracts", contracts);
        return "contracts";
    }

    @GetMapping("/add-form")
    public String showAddContractForm() {
        return "create-contract";
    }

    @PostMapping("/add")
    public String addContract(@ModelAttribute ContractCreateDto contractCreateDto) {
        return contractService.save(contractCreateDto)
                .map(contract -> "redirect:/contracts")
                .orElse("exception/data-not-saved");
    }
}

