package by.peregud.initech.llc.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserExistException.class)
    public String handleUserExist(UserExistException ex, RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("error message", ex.getMessage());
        return "redirect:registration";

    }


    @ExceptionHandler(RuntimeException.class)
    public String handleRuntime(RuntimeException ex, HttpServletRequest request, Model model) {

        model.addAttribute("error", "something went wrong: " + ex.getMessage());
        model.addAttribute("url", request.getRequestURL());
        return "error";
    }

}


