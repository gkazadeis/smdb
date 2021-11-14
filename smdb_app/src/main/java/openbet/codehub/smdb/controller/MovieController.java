package openbet.codehub.smdb.controller;

import lombok.RequiredArgsConstructor;
import openbet.codehub.smdb.domain.Movie;
import openbet.codehub.smdb.service.BaseService;
import openbet.codehub.smdb.service.MovieService;
import openbet.codehub.smdb.transfer.ApiResponse;
import openbet.codehub.smdb.transfer.MovieDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController extends AbstractController<Movie> {
    private final MovieService movieService;

    @Override
    public BaseService<Movie, Long> getBaseService() {
        return movieService;
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<MovieDetails>>> findAllMovies(){
        return ResponseEntity.ok(ApiResponse.<List<MovieDetails>>builder().data(movieService.findAllLazy()).build());
    }

    @GetMapping(params = {"category"})
    public ResponseEntity<ApiResponse<List<Movie>>> findByCategory(@RequestParam String category) {
        return ResponseEntity.ok(ApiResponse.<List<Movie>>builder().data(movieService.findByCategory(category)).build());
    }

    @GetMapping(params = {"title"})
    public ResponseEntity<ApiResponse<Movie>> findByTitle(@RequestParam String title) {
        return ResponseEntity.ok(ApiResponse.<Movie>builder().data(movieService.findByTitle(title)).build());
    }

    @GetMapping(params = {"top_rated"})
    public ResponseEntity<ApiResponse<List<Movie>>> findByTitle(@RequestParam int top_rated) {
        return ResponseEntity.ok(ApiResponse.<List<Movie>>builder().data(movieService.findTopRated(top_rated)).build());
    }

}
