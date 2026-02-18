package softuni.demo.patfinderEx.service;

import org.springframework.stereotype.Component;
import softuni.demo.patfinderEx.model.User;

@Component
public class CurrentUser {
    private User user;

    public CurrentUser() {
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {}

    public boolean isLoggedIn() {
        return this.user != null;
    }

}
