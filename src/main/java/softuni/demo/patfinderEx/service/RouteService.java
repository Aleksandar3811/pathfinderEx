package softuni.demo.patfinderEx.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.demo.patfinderEx.model.Picture;
import softuni.demo.patfinderEx.model.Route;
import softuni.demo.patfinderEx.model.dto.RouteShortInfoDTO;
import softuni.demo.patfinderEx.repository.RouteRepository;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RouteService {

    private final RouteRepository routeRepository;
    private Random random;
    private final ModelMapper modelMapper;



    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
        this.random = new Random();
        this.modelMapper = new ModelMapper();
    }

    @Transactional
    public List<RouteShortInfoDTO> getAll() {
         return routeRepository.findAll()
                 .stream()
                .map(this::mapToShortInfo)
                .toList();
    }

    private RouteShortInfoDTO mapToShortInfo(Route route) {
        RouteShortInfoDTO dto = modelMapper.map(route, RouteShortInfoDTO.class);
        Optional<Picture> first = route.getPictures().stream().findFirst();
        dto.setImageUrl(first.get().getUrl());
        return dto;
    }

    @Transactional
    public RouteShortInfoDTO getRandomRoute() {
        long routeCount = routeRepository.count();
        long randomId = random.nextLong(routeCount) + 1;

        Optional<Route> route = routeRepository.findById(randomId);

        return mapToShortInfo(route.get());


    }
}
