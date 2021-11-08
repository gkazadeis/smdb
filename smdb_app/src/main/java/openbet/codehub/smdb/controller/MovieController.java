package openbet.codehub.smdb.controller;

import lombok.RequiredArgsConstructor;
import openbet.codehub.smdb.domain.Movie;
import openbet.codehub.smdb.service.MovieService;
import openbet.codehub.smdb.transfer.ApiResponse;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<List<Movie>>> findAllMovies(){
        return ResponseEntity.ok(ApiResponse.<List<Movie>>builder().data(movieService.findAll()).build());
    }

    @GetMapping(params = {"category"})
    public ResponseEntity<ApiResponse<List<Movie>>> findByCategory(@RequestParam String category) {
        return ResponseEntity.ok(ApiResponse.<List<Movie>>builder().data(movieService.findByCategory(category)).build());
    }

}
