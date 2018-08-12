package pl.oskarpolak.blox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.oskarpolak.blox.models.forms.PostForm;
import pl.oskarpolak.blox.models.services.PostService;
import pl.oskarpolak.blox.models.services.UserService;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @GetMapping("/addpost")
    public String addPost(Model model){
        model.addAttribute("postForm", new PostForm());
        return "addpost";
    }

    @PostMapping("/addpost")
    public String addPost(@ModelAttribute PostForm postForm){
        if(!userService.isLogin()){
            return "redirect:/login";
        }

        postService.addPost(postForm);
        return "redirect:/";
    }





}
