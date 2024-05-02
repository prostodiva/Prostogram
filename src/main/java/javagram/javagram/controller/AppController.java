package javagram.javagram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import javagram.javagram.User;

@Controller
public class AppController {
    
     @GetMapping("/")
    public String getForm(Model model) {
        model.addAttribute("user", new User());
        return "sign-up";
    }
    @PostMapping("/submitItem")
    public String handleSubmit(@Valid User user, BindingResult result) {
        if (user.getFirstName().equals(user.getLastName())) result.rejectValue("lastName", "", "Please enter valid data");
        if (result.hasErrors()) return "sign-up";
        return "redirect:/result";
    }

    @GetMapping("/result")
    public String getResult() {
        return "result";
    }


    
}

//presentaition