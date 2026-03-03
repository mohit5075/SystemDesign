package repo;

import entities.Post;

import java.util.HashMap;
import java.util.Map;

public class PostRepo {
    Map<String, Post> postMap = new HashMap<>();
    public Post addPost(String content){
        Post post = new Post(content);
        postMap.put(post.getId(),post);
        return post;
    }
    public Post getPost(String id){
        return postMap.get(id);
    }
}
