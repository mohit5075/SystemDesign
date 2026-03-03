package observer;

import entities.Comment;
import entities.Post;
import entities.User;

public interface PostObserver {
    void onLike(Post post, User user);
    void onComment(Post post, Comment comment);
    void onPost(Post post);
}
