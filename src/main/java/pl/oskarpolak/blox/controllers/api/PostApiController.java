package pl.oskarpolak.blox.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping(value = "/post/{id}")
    public ResponseEntity getOnePost(@PathVariable("id") int id){
        Optional<PostEntity> postEntity = postService.getPostById(id);
//        if(postEntity.isPresent()){
//            return ResponseEntity.ok(postEntity.get());
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    //==
        return postEntity.map(s -> ResponseEntity.ok(s)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
