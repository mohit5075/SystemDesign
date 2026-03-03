import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupName;
    private String description;
    private List<User> users;
    public Group(String groupName, String description) {
        this.groupName = groupName;
        this.description = description;
        this.users = new ArrayList<>();
    }
    public void addUser(User user) {
        users.add(user);
    }
    public List<User> getUsers() {
        return users;
    }
}
