package softuni.demo.patfinderEx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.demo.patfinderEx.model.Route;


@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

}
