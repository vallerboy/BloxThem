package pl.oskarpolak.blox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.oskarpolak.blox.models.UserEntity;
import pl.oskarpolak.blox.models.repositories.UserRepository;
import pl.oskarpolak.blox.models.services.PostService;
import pl.oskarpolak.blox.models.services.UserService;

@Controller
public class MainController{

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @GetMapping("/")
    public String index(Model model){
        if(!userService.isLogin()){
            return "redirect:/login";
        }

        model.addAttribute("posts", postService.getAllPosts());
        model.addAttribute("user", userService);
        model.addAttribute("info", userService.isLogin() ? "Jestes zalogowany" : "Nie jestes");
        return "index";
    }
}
