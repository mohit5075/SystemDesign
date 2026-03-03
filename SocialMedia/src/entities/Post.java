package entities;

import observer.PostObserver;

import java.time.LocalDateTime;
import java.util.*;

public class Post {
    private String id;
    private String content;
    private LocalDateTime createdAt;
    private Set<User> likes;
    private List<Comment> comments;
    private List<PostObserver> postObservers;
    public Post(String content){
        this.id = UUID.randomUUID().toString();
        this.content = content;
        this.createdAt = LocalDateTime.now();
        likes = new HashSet<>();
        comments = new ArrayList<>();
        postObservers = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Set<User> getLikes() {
        return likes;
    }

    public void setLikes(Set<User> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        notifyOnComment(comment);
    }
    public void notifyOnComment(Comment comment){
        for(PostObserver postObserver : postObservers){
            postObserver.onComment(this,comment);
        }
    }
    public void notifyOnLike(User user){
        for(PostObserver postObserver : postObservers){
            postObserver.onLike(this,user);
        }
    }

    public void addLike(User user){
        likes.add(user);
        notifyOnLike(user);
    }
}
