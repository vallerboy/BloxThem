package pl.oskarpolak.blox.models.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.oskarpolak.blox.models.PostEntity;
import pl.oskarpolak.blox.models.forms.PostForm;
import pl.oskarpolak.blox.models.repositories.PostRepository;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    UserService userService;

    @Autowired
    PostRepository postRepository;

    public void addPost(PostForm postForm){
        PostEntity postEntity = new PostEntity();

        postEntity.setTitle(postForm.getTitle());
        postEntity.setContext(postForm.getContext());
        postEntity.setUser(userService.getUserData());

        postRepository.save(postEntity);
    }

    public void addPost(PostEntity postEntity){
        postRepository.save(postEntity);
    }

    public Optional<PostEntity> getPostById(int id){
        return postRepository.findById(id);
    }

    public Iterable<PostEntity> getAllPosts() {
        return postRepository.findAllByOrderByIdDesc();
    }

}
