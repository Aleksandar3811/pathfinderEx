package softuni.demo.patfinderEx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.demo.patfinderEx.model.dto.RouteShortInfoDTO;
import softuni.demo.patfinderEx.service.RouteService;

import java.util.List;

@Controller
public class RouteController {

    private RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public ModelAndView routes() {
        ModelAndView mv = new ModelAndView();
        //RouteShortInfoDTO randomRoute = routeService.getRandomRoute();
        List<RouteShortInfoDTO> routes = routeService.getAll();

        mv.setViewName("routes");
        mv.addObject("allRoutes", routes);
        return mv;

    }
}
