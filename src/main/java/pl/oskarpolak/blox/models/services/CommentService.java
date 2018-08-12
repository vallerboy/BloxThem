package pl.oskarpolak.blox.models.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.oskarpolak.blox.models.CommentEntity;
import pl.oskarpolak.blox.models.PostEntity;
import pl.oskarpolak.blox.models.forms.CommentForm;
import pl.oskarpolak.blox.models.repositories.CommentRepository;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserService userService;

    public void addComment(CommentForm commentForm, int postId){
        PostEntity postEntity = new PostEntity();
        postEntity.setId(postId);

        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setPost(postEntity);
        commentEntity.setContext(commentForm.getContext());
        commentEntity.setUser(userService.getUserData());

        commentRepository.save(commentEntity);
    }
}
