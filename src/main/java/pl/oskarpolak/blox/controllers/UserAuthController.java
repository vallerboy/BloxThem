package pl.oskarpolak.blox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.oskarpolak.blox.models.UserEntity;
import pl.oskarpolak.blox.models.forms.RegisterForm;
import pl.oskarpolak.blox.models.repositories.UserRepository;
import pl.oskarpolak.blox.models.services.UserService;

@Controller
public class UserAuthController {

    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute RegisterForm registerForm,
                           Model model) {
        //Sprawdzam czy login nie jest juz zajety
        if(userService.isUserExistByLogin(registerForm.getLogin())){
            model.addAttribute("info", "Ten login jest już zajęty");
            return "register";
        }
        userService.registerUser(registerForm);
        return "redirect:/login";
    }
}
