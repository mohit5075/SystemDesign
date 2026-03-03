package entities;

import observer.PostObserver;

import java.util.Set;
import java.util.UUID;

public class User implements PostObserver {
    private String id;
    private String name;
    private String email;
    private Set<User> followings;
    private Profile profile;
    public User(String name, String email){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<User> getFollowings() {
        return followings;
    }

    public void setFollowings(Set<User> followings) {
        this.followings = followings;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void addFollowing(User following){
        followings.add(following);
    }
    public void removeFollowing(User following){
        followings.remove(following);
    }

    @Override
    public void onLike(Post post, User user) {
        System.out.println(
                "Notification: " + user.getName() +
                        " liked your post " + post.getId()
        );
    }

    @Override
    public void onComment(Post post, Comment comment) {
        System.out.println(
                "Notification: " + comment.getUserId() +
                        " commented post " + post.getId()
        );
    }

    @Override
    public void onPost(Post post) {

    }
}
