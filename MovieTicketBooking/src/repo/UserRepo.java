package repo;

import entities.Seat;
import entities.User;

import java.util.Map;

public class UserRepo {
    private Map<String, User> userMap;

    public UserRepo(Map<String, User> userMap) {
        this.userMap = userMap;
    }
    public void addUser(User user){
        userMap.putIfAbsent(user.getId(),user);
    }
    public User getUser(String id){
        return userMap.get(id);
    }
}
