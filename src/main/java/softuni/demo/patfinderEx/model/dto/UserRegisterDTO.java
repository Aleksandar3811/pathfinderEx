package softuni.demo.patfinderEx.model.dto;

import jakarta.validation.constraints.*;

public class UserRegisterDTO {

    @NotBlank
    @Size(min=2)
    private String userName;

    @NotEmpty
    @Size(min = 5, max = 100)
    private String fullName;

    @Min(0)
    @Max(100)
    private Integer age;

    @Email
    private String email;

    @Size(min = 5, max = 100)
    private String password;


    private String confirmPassword;

    public UserRegisterDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
