package softuni.demo.patfinderEx.service;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import softuni.demo.patfinderEx.model.User;

@Component
@SessionScope
public class CurrentUser {
    private User user;

    public CurrentUser() {
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLoggedIn() {
        return this.user != null;
    }

    public boolean isAdmin() {
        return this.user.getRoles()
                .stream()
                .anyMatch(role -> role.getName().equals("ADMIN"));
    }

}
