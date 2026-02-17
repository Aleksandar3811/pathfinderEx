package softuni.demo.patfinderEx.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.demo.patfinderEx.model.dto.UserRegisterDTO;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/register")
    public ModelAndView viewRegister()
    {
        ModelAndView mv = new ModelAndView();
        mv.addObject("registerData", new UserRegisterDTO());
        mv.setViewName("register");
        return mv;
    }
    @PostMapping("/register")
    public ModelAndView doRegister(@Valid UserRegisterDTO data,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerData",data);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", bindingResult);
            mv.setViewName("redirect:/users/register");


            return mv;
        }

        mv.setViewName("redirect:/users/login");
        return mv;
    }

    @GetMapping("/login")
    public ModelAndView viewLogin()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }
}
