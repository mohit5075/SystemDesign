package entities;

import java.util.List;

public class Profile {
    List<Post> posts;

    public Profile(List<Post> posts) {
        this.posts = posts;
    }
    public void addPost(Post post){
        posts.add(post);
    }
    public void removePost(Post post){
        posts.remove(post);
    }
    public List<Post> getPosts(){
        return posts;
    }
}
