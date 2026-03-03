package strategy;

import entities.Post;

import java.util.Comparator;
import java.util.List;

public class TimestampBasedFeedSorting implements FeedSortingStrategy{
    @Override
    public List<Post> sortFeedPosts(List<Post> posts) {
        posts.sort(Comparator.comparing(Post::getCreatedAt).reversed());
        return posts;
    }
}
