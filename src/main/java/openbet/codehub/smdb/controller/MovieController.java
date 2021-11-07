package openbet.codehub.smdb.controller;

import lombok.RequiredArgsConstructor;
import openbet.codehub.smdb.domain.Category;
import openbet.codehub.smdb.domain.Movie;
import openbet.codehub.smdb.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/all")
    public List<Movie> findAllMovies(){
        return movieService.findAll();
    }

    @GetMapping(params = {"category"})
    public List<Movie> findByCategory(@RequestParam String category) {
        return movieService.findByCategory(category);
    }

}
