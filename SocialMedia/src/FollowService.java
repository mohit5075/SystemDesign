import entities.User;
import repo.UserRepo;

public class FollowService {
    private final UserRepo userRepo;

    public FollowService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void addFollower(String followerId,String followeeId){
        User follower = userRepo.getUser(followerId);
        User following = userRepo.getUser(followeeId);
        follower.addFollowing(following);
    }
    public void removeFollower(String followerId,String followeeId){
        User follower = userRepo.getUser(followerId);
        User following = userRepo.getUser(followeeId);
        follower.removeFollowing(following);
    }
}
