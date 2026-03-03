package repo;

import entities.Post;
import entities.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepo {
    Map<String, User> userMap = new HashMap<>();
    public void addUSer(String name,String email){
        User user = new User(name,email);
        userMap.put(user.getId(),user);
    }
    public User getUser(String id){
        return userMap.get(id);
    }
}
