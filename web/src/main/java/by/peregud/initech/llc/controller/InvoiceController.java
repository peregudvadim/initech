package by.peregud.initech.llc.controller;
import by.peregud.initech.llc.dto.InvoiceCreateDto;
import by.peregud.initech.llc.dto.InvoiceDto;
import by.peregud.initech.llc.service.InvoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public String showInvoices(Model model) {
        List<InvoiceDto> invoices = invoiceService.findAll();
        model.addAttribute("invoices", invoices);
        return "invoices";
    }

    @GetMapping("/add-form")
    public String showAddInvoiceForm() {
        return "create-invoice";
    }

    @PostMapping("/add")
    public String addInvoice(@ModelAttribute InvoiceCreateDto invoiceCreateDto) {
        return invoiceService.save(invoiceCreateDto)
                .map(inv -> "redirect:/invoices")
                .orElse("exception/data-not-saved");
    }
}

