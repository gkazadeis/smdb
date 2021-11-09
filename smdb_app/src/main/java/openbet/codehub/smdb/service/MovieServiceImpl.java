package openbet.codehub.smdb.service;

import lombok.RequiredArgsConstructor;
import openbet.codehub.smdb.domain.Movie;
import openbet.codehub.smdb.repository.MovieRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl extends BaseServiceImpl<Movie> implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public JpaRepository<Movie, Long> getRepository() {
        return movieRepository;
    }

    @Override
    public List<Movie> findByCategory(final String category) {
        return movieRepository.findAll().stream().filter(m -> m.getCategory().toString().equals(category)).collect(Collectors.toList());
    }

    @Override
    public Movie findByTitle(final String title) {
        return movieRepository.findAll().stream().filter(m -> m.getTitle().equals(title)).findAny().orElse(null);
    }

}
