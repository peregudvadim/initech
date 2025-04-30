package by.peregud.initech.llc.controller;

import by.peregud.initech.llc.dto.TransactionCreateDto;
import by.peregud.initech.llc.dto.TransactionDto;
import by.peregud.initech.llc.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public String showTransactions(Model model) {
        List<TransactionDto> transactions = transactionService.findAll();
        model.addAttribute("transactions", transactions);
        return "transactions";
    }

    @GetMapping("/add-form")
    public String showAddTransactionForm() {
        return "create-transaction";
    }

    @PostMapping("/add")
    public String addTransaction(@ModelAttribute TransactionCreateDto transactionCreateDto) {
        return transactionService.save(transactionCreateDto)
                .map(t -> "redirect:/transactions")
                .orElse("exception/data-not-saved");
    }
}
