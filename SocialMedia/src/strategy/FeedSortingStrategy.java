package strategy;

import entities.Post;

import java.util.List;

public interface FeedSortingStrategy {
    List<Post> sortFeedPosts(List<Post> posts);
}
