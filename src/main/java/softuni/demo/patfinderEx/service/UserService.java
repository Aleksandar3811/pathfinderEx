package softuni.demo.patfinderEx.service;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.demo.patfinderEx.model.User;
import softuni.demo.patfinderEx.model.dto.UserLoginDTO;
import softuni.demo.patfinderEx.model.dto.UserProfileDTO;
import softuni.demo.patfinderEx.model.dto.UserRegisterDTO;
import softuni.demo.patfinderEx.repository.UserRepository;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    public void register(UserRegisterDTO userRegisterDTO) {
        User user = modelMapper.map(userRegisterDTO, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        userRepository.save(user);
    }

    public void login(UserLoginDTO userLoginDTO) {
        User user = userRepository.findByUsername(userLoginDTO.getUserName());
        if (user == null) {
            throw new RuntimeException("Username not valid!");
        }
        if (passwordEncoder.matches(userLoginDTO.getPassword(), user.getPassword()) && !currentUser.isLoggedIn()) {
            currentUser.setUser(user);

        }

    }

    public void logout() {
        currentUser.setUser(null);
    }

    public UserProfileDTO getProfileData(){
        return modelMapper.map(currentUser.getUser(), UserProfileDTO.class);
    }
}
