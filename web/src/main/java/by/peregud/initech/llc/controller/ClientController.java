package by.peregud.initech.llc.controller;

import by.peregud.initech.llc.dto.ClientCreateDto;
import by.peregud.initech.llc.dto.ClientDto;
import by.peregud.initech.llc.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String showClients(Model model) {
        List<ClientDto> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "clients";
    }

    @GetMapping("/add-form")
    public String showAddClientForm() {
        return "create-client";
    }

    @PostMapping("/add")
    public String addClient(@ModelAttribute ClientCreateDto clientCreateDto) {
        return clientService.save(clientCreateDto)
                .map(client -> "redirect:/clients")
                .orElse("exception/data-not-saved");
    }
}
