import entities.Post;
import entities.User;
import repo.UserRepo;

import java.util.List;

public class ProfileService {
    private final UserRepo userRepo;

    public ProfileService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<Post> getProfile(String userId){
        User user = userRepo.getUser(userId);
        return user.getProfile().getPosts();
    }
}
