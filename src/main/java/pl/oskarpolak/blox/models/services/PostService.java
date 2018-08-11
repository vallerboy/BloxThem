package pl.oskarpolak.blox.models.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.oskarpolak.blox.models.PostEntity;
import pl.oskarpolak.blox.models.forms.PostForm;
import pl.oskarpolak.blox.models.repositories.PostRepository;

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
        postEntity.setUserId(userService.getUserData().getId());

        postRepository.save(postEntity);
    }

}
