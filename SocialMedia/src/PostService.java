import entities.Comment;
import entities.Post;
import entities.User;
import repo.PostRepo;
import repo.UserRepo;

import java.util.HashMap;
import java.util.Map;

public class PostService {
    private final PostRepo postRepo;
    private final UserRepo userRepo;

    public PostService(PostRepo postRepo, UserRepo userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    public void addPost(String userId,String content){
        Post post = postRepo.addPost(content);
        User user = userRepo.getUser(userId);
        user.getProfile().addPost(post);
    }
    public void addComment(String content, String userId, String postId){
        Post post = postRepo.getPost(postId);
        Comment comment = new Comment(content,userId);
        post.addComment(comment);
    }
}
