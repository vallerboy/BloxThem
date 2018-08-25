package pl.oskarpolak.blox.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.oskarpolak.blox.models.PostEntity;
import pl.oskarpolak.blox.models.services.PostService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @Autowired
    PostService postService;

    @GetMapping(value = "/post", produces = "application/json")
    public ResponseEntity getAllPosts() {
       return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping(value = "/post/{id}", produces = "application/json")
    public ResponseEntity getOnePost(@PathVariable("id") int id){
        Optional<PostEntity> postEntity = postService.getPostById(id);
//        if(postEntity.isPresent()){
//            return ResponseEntity.ok(postEntity.get());
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    //==
        return postEntity.map(s -> ResponseEntity.ok(s)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping(value = "/post", consumes = "application/json")
    public ResponseEntity createOnePost(@RequestBody PostEntity post){
        postService.addPost(post);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(value = "/post/{id}" )
    public ResponseEntity deleteOnePost(@PathVariable("id") int id){
        postService.deletePostById(id);
        return ResponseEntity.ok().build();
    }
}
