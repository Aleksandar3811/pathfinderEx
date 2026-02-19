package softuni.demo.patfinderEx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView index() {

        double sofiaTemp = new Random().nextDouble();

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("sofiaTemp", sofiaTemp);


        return mv;
    }

    @GetMapping("/about")
    public ModelAndView about() {

        ModelAndView mv = new ModelAndView("about");

        return mv;
    }
}
