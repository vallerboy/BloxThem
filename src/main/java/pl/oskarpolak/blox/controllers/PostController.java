package pl.oskarpolak.blox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.oskarpolak.blox.models.forms.PostForm;
import pl.oskarpolak.blox.models.services.PostService;

import java.util.stream.IntStream;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/addpost")
    public String addPost(Model model){
        model.addAttribute("postForm", new PostForm());
        return "addpost";
    }

    @PostMapping("/addpost")
    public String addPost(@ModelAttribute PostForm postForm){
        postService.addPost(postForm);

        return "redirect:/";
    }



}
