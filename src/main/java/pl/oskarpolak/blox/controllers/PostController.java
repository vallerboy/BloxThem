package pl.oskarpolak.blox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.oskarpolak.blox.models.PostEntity;
import pl.oskarpolak.blox.models.forms.CommentForm;
import pl.oskarpolak.blox.models.forms.PostForm;
import pl.oskarpolak.blox.models.services.CommentService;
import pl.oskarpolak.blox.models.services.PostService;
import pl.oskarpolak.blox.models.services.UserService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @Autowired
    CommentService commentService;

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

    @GetMapping("/post/{id}")
    public String showPost(@PathVariable("id") int id, Model model){
          Optional<PostEntity> postEntity = postService.getPostById(id);
        if(postEntity.isPresent()){
            model.addAttribute("post", postEntity.get());
        }
        model.addAttribute("commentForm", new CommentForm());
        return postEntity.isPresent() ? "post" : "redirect:/";
//        return   postService.getPostById(id).map(s -> {
//                      model.addAttribute("post", s);
//                      return "post";
//        }).orElse("redirect:/");
    }

    @PostMapping("/comment/{id}")
    public String addComment(@ModelAttribute @Valid CommentForm commentForm,
                             BindingResult bindingResult,
                             @PathVariable("id") int postId){
        if(!userService.isLogin()){
            return "redirect:/login";
        }
        if(!bindingResult.hasErrors()) {
            commentService.addComment(commentForm, postId);
        }
        return "redirect:/post/" + postId;
    }






}
