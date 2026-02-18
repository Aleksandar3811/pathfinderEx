package softuni.demo.patfinderEx.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.demo.patfinderEx.model.Level;
import softuni.demo.patfinderEx.model.dto.UserLoginDTO;
import softuni.demo.patfinderEx.model.dto.UserRegisterDTO;
import softuni.demo.patfinderEx.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public ModelAndView viewRegister() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("registerData", new UserRegisterDTO());
        mv.addObject("levels", Level.values());
        mv.setViewName("register");
        return mv;
    }

    @PostMapping("/register")
    public ModelAndView doRegister(@Valid UserRegisterDTO data,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerData", data);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", bindingResult);
            mv.setViewName("redirect:/users/register");


            return mv;
        }
        userService.register(data);
        mv.setViewName("redirect:/users/login");
        return mv;
    }

    @GetMapping("/login")
    public ModelAndView viewLogin() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("loginData", new UserLoginDTO());
        mv.setViewName("login");
        return mv;
    }
    @PostMapping("/login")
    public ModelAndView doLogin(@Valid UserLoginDTO data,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginData", data);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", bindingResult);
            mv.setViewName("redirect:/users/login");


            return mv;
        }
        userService.login(data);
        mv.setViewName("redirect:/");
        return mv;

    }
}
