package softuni.demo.patfinderEx.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserLoginDTO {

    @NotBlank
    @Size(min=2)
    private String userName;

    @Size(min = 5, max = 100)
    private String password;

    public UserLoginDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
