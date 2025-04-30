package by.peregud.initech.llc.controller;

import by.peregud.initech.llc.dto.PaymentCreateDto;
import by.peregud.initech.llc.dto.PaymentDto;
import by.peregud.initech.llc.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public String showPayments(Model model) {
        List<PaymentDto> payments = paymentService.findAll();
        model.addAttribute("payments", payments);
        return "payments";
    }

    @GetMapping("/add-form")
    public String showAddPaymentForm() {
        return "create-payment";
    }

    @PostMapping("/add")
    public String addPayment(@ModelAttribute PaymentCreateDto paymentCreateDto) {
        return paymentService.save(paymentCreateDto)
                .map(p -> "redirect:/payments")
                .orElse("exception/data-not-saved");
    }
}
