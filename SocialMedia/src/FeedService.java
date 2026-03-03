import entities.Post;
import entities.User;
import repo.UserRepo;
import strategy.FeedSortingStrategy;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FeedService {
    private FeedSortingStrategy feedSortingStrategy;
    private final UserRepo userRepo;
    public FeedService(FeedSortingStrategy feedSortingStrategy, UserRepo userRepo){
        this.feedSortingStrategy = feedSortingStrategy;
        this.userRepo = userRepo;
    }
    public List<Post> getFeed(String userId){
        User user = userRepo.getUser(userId);
        List<Post> feed = new ArrayList<>();
        for(User followed : user.getFollowings()){
            feed.addAll(followed.getProfile().getPosts());
        }
        return feedSortingStrategy.sortFeedPosts(feed);
    }
}
